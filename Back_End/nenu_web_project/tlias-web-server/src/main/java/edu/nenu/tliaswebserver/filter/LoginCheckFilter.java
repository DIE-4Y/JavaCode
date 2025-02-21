package edu.nenu.tliaswebserver.filter;

import com.alibaba.fastjson.JSONObject;
import edu.nenu.tliaswebserver.pojo.Result;
import edu.nenu.tliaswebserver.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 获取请求地址url
        String url = httpServletRequest.getRequestURI();

        // 判断地址是否含有login 直接放行
        if (url.contains("login")) {
            log.info("登录请求直接放行");
            chain.doFilter(request, response);
            return;
        }

        // 获取token令牌
        String jwt = httpServletRequest.getHeader("token");

        // 判断有没有token令牌
        if (!StringUtils.hasLength(jwt)) {
            log.info("没有token令牌");
            Result error = Result.error("NOT_LOGIN");
            String jwtString = JSONObject.toJSONString(error);//错误转为json对象
            response.getWriter().write(jwtString);//响应返回错误对象
            return;
        }

        // 验证token令牌是否合法
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败, 返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String jwtString = JSONObject.toJSONString(error);
            response.getWriter().write(jwtString);
            return;
        }

        // 放行
        log.info("解析通过放行");
        chain.doFilter(request, response);
    }
}
