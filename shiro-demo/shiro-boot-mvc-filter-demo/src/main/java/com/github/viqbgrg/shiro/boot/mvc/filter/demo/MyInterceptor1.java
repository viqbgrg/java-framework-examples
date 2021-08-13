package com.github.viqbgrg.shiro.boot.mvc.filter.demo;

import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hhj
 */
@Component
public class MyInterceptor1 extends PathMatchingFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();
        pathsMatch("/test", request);
        System.out.println("MyInterceptor1 拦截器执行preHandle方法");
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("MyInterceptor1 拦截器执行afterCompletion方法");

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 拦截器执行postHandle()方法");

    }
}