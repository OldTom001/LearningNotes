package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");

        //2. 获取数据
        //2.1 获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");

        //3. 校验验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); //确保验证码一次性

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg", "验证码错误!");
            //跳转登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

            return;
        }

        //4. 封装user对象
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5. 调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        //6. 判断是否登陆成功
        if(loginUser != null) {
            //登陆成功
            request.getSession().setAttribute("user", loginUser);
//            User user1 = (User)request.getSession().getAttribute("user");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else{
            //登陆失败
            request.setAttribute("login_msg", "用户名或密码错误!");
            //跳转登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
