package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("方法被执行了");
        //完成方法分发
        //1. 获取请求路径
        String uri = req.getRequestURI(); ///travel/user/add
        System.out.println("请求的uri: "+ uri);
        //2. 获取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("方法名称: " + methodName);
        //3. 获取方法对象method
        //this: 谁调用谁是this, 这里是UserServlet的对象
//        System.out.println(this);
        try {
            //忽略访问权限修饰符获取方法, 包括私有方法
            //Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //直接把方法修饰符改成public, 不要用declared, 也不要用暴力放射
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //暴力反射
            //method.setAccessible(true);
            //4. 执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将传入的对象序列化为json, 并写回客户端
     * @param obj
     * @param response
     * @throws IOException
     */
    public void writeValue(Object obj, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), obj);
    }

    /**
     * 将传入的对象序列化为json, 并返回
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
