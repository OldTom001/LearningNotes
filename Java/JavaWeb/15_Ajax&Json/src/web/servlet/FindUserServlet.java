package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 校验用户名是否存在
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收数据
        String username = request.getParameter("username");

        //2. 调用service层判断用户名是否存在, 这里简化操作, 不再查询数据库
        response.setContentType("text/html;charset=utf-8");
        //将响应数据直接设置成json格式
//        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<>();
        if("tom".equals(username)) {
            //用户名已经存在
            //构造响应信息
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎, 请更换一个");
        } else{
            //用户名不存在, 可以使用
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }
        // 将相应信息转换成json字符串, 并发送到客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
