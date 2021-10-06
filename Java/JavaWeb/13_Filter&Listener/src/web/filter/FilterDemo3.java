package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.function.DoubleToIntFunction;

/**
 * 过滤器方法的生命周期
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 服务器关闭后, Filter对象被销毁, 若服务器是正常关闭, 则会执行desdroy方法
     * 执行一次
     * 用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
     * 每一次请求被拦截资源时, 都会执行
     * 执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("doFilter...");

        chain.doFilter(req, resp);


    }

    /**
     * 服务器启动后, 创建Filter对象, 调用init方法
     * 执行一次
     * 用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

}
