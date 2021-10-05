package servllet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆案例: 登陆服务器, 校验用户名, 密码及验证码
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1. 设置request编码
        request.setCharacterEncoding("utf-8");
//        2. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
//        3. 判断验证码是否正确
//        先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码, 防止出现重复的验证码, 提高安全性
        session.removeAttribute("checkCode_session");

//        忽略大小写比较字符串
//        非空判断是为了防止删除session中存储的验证码后出现空指针异常
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)) {
            if("zhangsan".equals(username) && "123".equals(password)) {
                //成功
                //存储信息, 在访问成功的页面显示用户名
                session.setAttribute("user", username);

                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() +"/success.jsp");
            } else{
                //用户名或密码错误
                request.setAttribute("login_error", "用户名或密码错误");
                //转发
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
