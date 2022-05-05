package com.controller;

import com.bean.Role;
import com.bean.Root;
import com.bean.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*用来代替servlet*/
@Controller
public class LoginController {
    @Autowired
    public UserService userService;
    /*去登录页面*/
    /*2种方法*/
    //@GetMapping("login")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /*登陆处理*/
   // @PostMapping("login")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userName, String userPwd, HttpSession session, Model model,HttpServletResponse response) throws IOException, ServletException {
    //接收参数
        System.out.println("userName:"+userName);
        /*String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");*/
        User user = userService.login(userName,userPwd);
       int roleid =  user.getRole().getRoleId();
        List<Root> list =  userService.selectByRole(roleid);
        List<String> list1 = new ArrayList<>();
        String o = null;
        for (int i = 0; i < list.size(); i++) {
           o  = list.get(i).getFunction().getFunUrl();
            list1.add(o);
        }
      // Root root =  userService.selectByRole(user.getRole().getRoleId());
       // System.out.println("==========="+root.getFunction().getFunUrl());
        if(user!=null){

            /* 登陆成功保存标识*/
            //request.getSession().setAttribute("login", user);
            session.setAttribute("login", user);
            session.setAttribute("listRoolFun",list1);
            //Ajax传送数据:response.getWriter().write("1");
             return "redirect:/myjsp";
        }else{
           // request.setAttribute("error","账号或密码不正确");
            //如何向客户端携带数据
            model.addAttribute("error","账号或密码不正确");
            //request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
           //如何请求转发
            return "login";
        }
    }
    //params参数：请求/login2时，必须要携带参数
    /*@RequestMapping(value = "/login2",method = RequestMethod.GET,params = {"user"})
    public String login2(String userName, String userPwd, HttpSession session, Model model,HttpServletResponse response) throws IOException, ServletException {
        //接收参数00
        System.out.println("进入dologin");
        *//*String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");*//*
        System.out.println(userName+"--"+userPwd);
        User user = userService.login(userName,userPwd);
        System.out.println("查询出user"+user);
        if(user!=null){
            *//* 登陆成功保存标识*//*
            //request.getSession().setAttribute("login", user);
            session.setAttribute("login", user);
            response.getWriter().write("1");
            return null;
        }else{
            // request.setAttribute("error","账号或密码不正确");
            //如何向客户端携带数据
            model.addAttribute("error","账号或密码不正确");
            //request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
            //如何请求转发
            return "login";
        }
    }*/
}


