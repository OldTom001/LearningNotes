package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器执行流程
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request请求对象增强
        System.out.println("FilterDemo2执行了...");
        //放行
        chain.doFilter(req, resp);
        //对response响应对象增强
        System.out.println("FilterDemo2回来了...");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
