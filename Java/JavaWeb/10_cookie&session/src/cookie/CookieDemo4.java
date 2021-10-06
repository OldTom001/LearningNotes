package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie持久化存储
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        创建cookie
        Cookie c1 = new Cookie("msg", "hello");

//        设置cookie存活时间
        c1.setMaxAge(30);//将cookie写入硬盘, 30s后删除, edge浏览器无效, chrome, firebox均可删除
//        c1.setMaxAge(0); //删除前的cookie, edge浏览器删不掉

//        发送cookie
        response.addCookie(c1); //msg:hello

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
