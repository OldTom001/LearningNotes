package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取请求参数
        String username = request.getParameter("username");
/*        System.out.println("post");
        System.out.println(username);*/
//        获取请求参数数组
        String[] hobbies = request.getParameterValues("hobby");
/*        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/
//        获取所有的请求参数名称
        Enumeration<String> names = request.getParameterNames();
/*        while (names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
//            System.out.println("--------");
        }*/
//        获取所有参数的map集合
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("key: " + key);
            String[] value = map.get(key);
            System.out.println("value: ");
            for (String s : value) {
                System.out.println(s);
            }
            System.out.println("--------");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/
//        由于getParameter方法对get和post通用, 因此只需调用doPost中的方法即可, 无需重新写
        this.doPost(request, response);
    }
}
