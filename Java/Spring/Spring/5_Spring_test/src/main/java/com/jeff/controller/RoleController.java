package com.jeff.controller;

import com.jeff.domain.Role;
import com.jeff.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    //角色查询, 返回角色列表
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        System.out.println(roleList);
        return modelAndView;
    }

    //角色保存, 用于新增角色的保存
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect: /5_Spring_test_war_exploded/role/list";
    }

}
