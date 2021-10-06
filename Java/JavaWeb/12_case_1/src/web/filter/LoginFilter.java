package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器, 在用户访问资源前先验证登录状态, 若未登陆则先跳转到登陆界面
 */
@WebFilter(value = "/*", dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0. 强制转换, ServletRequest接口中没有getRequestURI方法, 其实现类HttpServletRequest中才有,
        //因此通常做一个强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //1. 获取资源的请求路径
        String uri = request.getRequestURI();
        //2. 判断uri是否包含登陆相关的资源路径, 注意要排除css/js/图片/验证码等资源
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCodeServlet")) {
            //包含, 用户就是想登陆, 放行
            chain.doFilter(req, resp);
        } else {
            //不包含, 需要验证用户是否已经登陆
            //3. 从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user !=null) {
                //已经登陆, 放行
                chain.doFilter(req, resp);
            } else{
                //没有登陆, 跳转到登陆页面
                request.setAttribute("login_msg", "您尚未登陆, 请登陆");
//                HttpServletResponse response = (HttpServletResponse) resp;
//                response.sendRedirect("/case_1/login.jsp");
                request.getRequestDispatcher("login.jsp").forward(request, resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
