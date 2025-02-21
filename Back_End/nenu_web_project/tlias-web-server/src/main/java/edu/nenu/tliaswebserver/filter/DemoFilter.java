package edu.nenu.tliaswebserver.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/*
    使用webfilter必须在启动类里加上注解--@ServletComponentScan
 */
//@WebFilter(urlPatterns = "/*")      //所有路径拦截
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("dofilter被调用了");
        chain.doFilter(request, response);  //放行
    }
}
