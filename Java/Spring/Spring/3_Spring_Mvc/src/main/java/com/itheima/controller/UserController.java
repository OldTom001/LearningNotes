package com.itheima.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user") //第一级访问目录
public class UserController {

    //请求地址: http://localhost:8080/quick  http://localhost:8080/user/quick
//    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    @RequestMapping(value = "/quick")
    public String save(){
        System.out.println("Controller save running...");
//        return "jsp/success.jsp"; //默认省略了forward(内部资源解析器InternalResourceViewResolver中定义的默认前缀), 转发, 显示页面改变, 地址栏不变
//        return "redirect:/jsp/success.jsp"; //重定向, 地址栏改变
        return "success"; //在spring-mvc中配置了前后缀后, 相当于return "/jsp/success.jsp";
    }


    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /*
            Model: 模型, 用于封装数据
            View: 视图, 用于展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","盘丝洞");//相当于将键值对放到request域中
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //框架自动传参
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username", "白骨精");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //数据和视图拆分
    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username", "唐僧");
        return "success";
    }

    //向request中存数据
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username", "猪悟能");
        return "success";
    }

    //直接回写字符串
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello world");
    }

    //通过@ResponseBody注解回写字符串
    @RequestMapping("/quick7")
    @ResponseBody //告知SpringMVC框架, 不进行视图跳转, 直接进行数据响应.
    public String save7() throws IOException {
        return "hello springMVC!!!";
    }

    //返回json格式的字符串
    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"name\":\"zhangsan\",\"age\":18}"; //注意内层的双引号需要转义
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(18);
        user.setAddr("xi'an");
        //使用json的转换工具将对象转换成json格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    //SpringMVC自动将User转换成json格式的字符串.
    //在spring-mvc.xml中配置了json转换器后, save9就失效了.
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(18);
        user.setAddr("xi'an");
        return user;
    }

    @RequestMapping("/quick11")
    @ResponseBody//这个注解不能删, 不进行页面跳转, 且回显void
    public void quick11(String username,int age) throws IOException { //age写String类型和int类型都可以, SpringMVC会自动转换类型
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void quick12(User user) throws IOException { //入口参数为想要封装的类型
        System.out.println(user);
    }

    @RequestMapping("/quick13")
    @ResponseBody
    public void quick13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void quick14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value="name",required = false,defaultValue = "itcast") String username) throws IOException {
        System.out.println(username);
    }

    //Restful风格的请求: localhost:80/user/quick17/zhangsan
    //method参数指定支持的请求方法
    @RequestMapping(value = "/quick17/{username}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void save17(@PathVariable(value = "username",required = true) String name){
        System.out.println(name);
    }

    //localhost:80/user/quick18/date=2022-12-12
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date){
        System.out.println(date);
    }

    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick20")
    @ResponseBody
    public void saave20(@RequestHeader(value = "User-Agent",required = false) String headerValue){
        System.out.println(headerValue);
    }

    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID",required = false) String jsessionid){
        System.out.println(jsessionid);
    }

    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException { //uploadFile需要与表单中文件名称一致
        System.out.println(username);
        System.out.println(uploadFile);
        String originalFilename = uploadFile.getOriginalFilename();//获取文件名称
        //保存文件
        uploadFile.transferTo(new   File("C:\\Users\\NUOSEN\\Desktop\\uploadTest\\"+originalFilename));//保存文件
    }

    @RequestMapping("/quick23")
    @ResponseBody
    public void save23(String username,MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile uploadFile : uploadFiles){
            String originalFilename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new   File("C:\\Users\\NUOSEN\\Desktop\\uploadTest\\"+originalFilename));
        }
    }

}
