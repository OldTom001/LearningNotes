package servllet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * 登陆案例: 登陆服务器, 校验用户名, 密码及验证码
 * 改进: 用map封装参数, 链接数据库
 */
@WebServlet("/loginServlet1")
public class LoginServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        1. 设置request编码
        request.setCharacterEncoding("utf-8");
/*//        2. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");*/

//        2. 获取参数

/*        String username = null;
        String password = null;*/

        Map<String, String[]> map = request.getParameterMap();
        String checkCode = map.get("checkCode")[0];

        // 这个map是上锁的, 无法直接删除, 需要先用反射解锁
//        map.remove("checkCode");
        try {
            Method method = map.getClass().getMethod("setLocked", new Class[]{boolean.class});
            //解锁
            method.invoke(map, new Object[]{new Boolean(false)});
            map.remove("checkCode");
            //重新上锁
            method.invoke(map, new Object[]{new Boolean(true)});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //将map中的username和password封装成user对象
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        /*Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if("username".equals(key)) {
                username = map.get(key)[0];
            } else if("password".equals(key)){
                password = map.get(key)[0];
            } else if("checkCode".equals(key)) {
                checkCode = map.get(key)[0];
            }
        }*/

//        3. 判断验证码是否正确
//        先获取生成的验证码
                ;
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //删除session中存储的验证码, 防止出现重复的验证码, 提高安全性
        session.removeAttribute("checkCode_session");

//        忽略大小写比较字符串
//        非空判断是为了防止删除session中存储的验证码后出现空指针异常
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)) {

            UserDao dao = new UserDao();
            User realUser = new User();
            if((realUser=dao.login(loginUser))!=null){
                session.setAttribute("user", realUser.getUsername());
                response.sendRedirect(request.getContextPath() +"/success.jsp");
            }

            /*if("zhangsan".equals(username) && "123".equals(password)) {
                //成功
                //存储信息, 在访问成功的页面显示用户名
                session.setAttribute("user", username);

                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() +"/success.jsp");
            }*/
           else{
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
