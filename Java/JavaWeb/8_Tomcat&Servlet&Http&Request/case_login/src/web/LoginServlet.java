package web;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登陆服务, 判断用户名和密码是否正确
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 设置编码
        request.setCharacterEncoding("utf-8");

/*        //2. 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //3. 封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        //2. 获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();

        //3.1 创建User对象
        User loginUser = new User();
        //3.2 使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4. 调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //5. 判断user
        if(user == null){
            //登陆失败
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else{
            //登陆成功
            //存储数据
            request.setAttribute("user", user);
            //转发
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }


    }
}
