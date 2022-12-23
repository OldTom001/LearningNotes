package com.jeff.controller;

import com.alibaba.druid.stat.TableStat;
import com.jeff.domain.Role;
import com.jeff.domain.User;
import com.jeff.service.RoleService;
import com.jeff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //用户查询, 返回用户列表
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.list();
        //设置模型
        modelAndView.addObject("userList",userList);
        //设置视图
        modelAndView.setViewName("user-list");
        System.out.println(userList);
        return modelAndView;
    }

    //用于用户添加界面的用户角色显示, 返回roleList
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    //保存新添加的用户
    @RequestMapping("/save")
    public String save(User user, long[] roleIds){
        userService.save(user, roleIds);
        return  "redirect: /5_Spring_test_war_exploded/user/list";
    }

    //删除用户
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") long userId){
        userService.del(userId);
        return "redirect: /5_Spring_test_war_exploded/user/list";
    }

    //用户登陆
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        if(user!=null){
            session.setAttribute("user", user);
            return"redirect: /5_Spring_test_war_exploded/index.jsp";
        }
        return"redirect: /5_Spring_test_war_exploded/login.jsp";
    }

}
