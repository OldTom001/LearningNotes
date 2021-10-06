package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 拦截方式(资源被访问的方式)配置示例
 */
//浏览器直接请求资源时执行过滤器
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
//转发访问时执行过滤器
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
//直接请求, 或转发访问时, 执行过滤器
//@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FileterDemo5...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
