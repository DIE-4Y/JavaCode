package edu.nenu.tliaswebserver.interceptor;

import com.alibaba.fastjson.JSONObject;
import edu.nenu.tliaswebserver.pojo.Result;
import edu.nenu.tliaswebserver.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标资源运行前进行调用
     * 通过该返回true 不通过返回false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取url地址
        String url = request.getRequestURI();
        log.info("请求的url: {}",url);

        // 判断路径是否是登录
        if (url.contains("login")){
            log.info("登录请求，放行");
            return true;
        }

        // 判断是否含有jwt令牌
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("没有jwt令牌");
            Result error = Result.error("NTO_LOGIN");
            response.getWriter().write(JSONObject.toJSONString(error));
            return false;
        }

        // 解析令牌
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("令牌解析失败");
            Result error = Result.error("NTO_LOGIN");
            response.getWriter().write(JSONObject.toJSONString(error));
            return false;
        }

        // 解析成功
        return true;
    }

    /**
     * 目标资源运行后执行
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
     * execution, for type and/or instance examination
     * @param modelAndView the {@code ModelAndView} that the handler returned
     * (can also be {@code null})
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 视图渲染后进行调用
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
     * execution, for type and/or instance examination
     * @param ex any exception thrown on handler execution, if any; this does not
     * include exceptions that have been handled through an exception resolver
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
