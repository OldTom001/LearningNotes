package web.servletcontex;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContex功能
 */
@WebServlet("/servletContexDemo1")
public class ServletContexDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context1 = request.getServletContext();
        System.out.println(context1); //org.apache.catalina.core.ApplicationContextFacade@1e49d884

        ServletContext context2 = this.getServletContext();
        System.out.println(context2);

        System.out.println("--------");
        System.out.println(context1==context2);  //true
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
