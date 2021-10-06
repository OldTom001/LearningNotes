package web.servletcontex;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContex获取真实路径(服务器路径)
 */
@WebServlet("/servletContexDemo5")
public class ServletContexDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();

        //获取文件的服务器路径(不是工作空间路径)
        String b = context.getRealPath("/b.txt"); //web下的文件目录,
        //-表示E:\LearningNotes\Java\JavaWeb\HttpResponse\out\artifacts\HttpResponse_war_exploded
        System.out.println(b);

        String c = context.getRealPath("/WEB-INF/c.txt"); //WEB-INF下的文件目录
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt"); //src下的文件目录
        System.out.println(a);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
