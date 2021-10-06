package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //1. 获取id
        String id = request.getParameter("id");
        //2. 调用service查询
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        //3. 存储user对象
        if(user != null){
        request.setAttribute("user", user);
        //4. 转发user对象
        request.getRequestDispatcher("/update.jsp").forward(request, response);
        } else return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
