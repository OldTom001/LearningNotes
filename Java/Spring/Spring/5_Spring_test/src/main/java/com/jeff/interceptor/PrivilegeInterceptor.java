package com.jeff.interceptor;

import com.jeff.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器, 用于判断用户是否登陆
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑: 判断用户是否登陆, 本质是判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            //没有登陆, 跳转到登陆界面
            response.sendRedirect("/5_Spring_test_war_exploded/login.jsp");
            return false;
        }
        //已登陆, 放行
        return true;
    }
}
