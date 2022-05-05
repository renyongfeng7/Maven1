package com.controller;

import com.bean.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    public UserService userService;
    @RequestMapping("user")
    public String user(Model model){
        List<User> list = userService.selectAll();
        model.addAttribute("list",list);
        return "user";
    }
    @RequestMapping("dodeleteuser")
    public String dodeleteuser(String id){
       int id1 =  Integer.parseInt(id);
    userService.deleteById(id1);
        return "redirect:/user";
    }

    @RequestMapping("useradd")
    public String useradd(){
        return "useradd";
    }
@RequestMapping("doadduser")
    public String useradd(String realName,String userName,String userPwd) throws UnsupportedEncodingException {
        realName= new String (realName.getBytes("ISO-8859-1"),"UTF-8");
        userName = new String (userName.getBytes("ISO-8859-1"),"UTF-8");
        User user = new User(realName,userName,userPwd);
        userService.save(user);
        return "redirect:/user";
    }

    @RequestMapping("useredit")
    public String useredit(String id,Model model){
        model.addAttribute("User",userService.selectById( Integer.parseInt(id)));
        return "useredit";
    }

    @RequestMapping("doedituser")
    public String doedituser(String realName,String userName,String userPwd,int userId) throws UnsupportedEncodingException {
        realName = new String(realName.getBytes("ISO-8859-1"), "utf-8");
        userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(realName+"--"+userName+"--"+userPwd+"--"+userId);
    User user = new User(userId,realName,userName,userPwd);
    userService.update(user);
    return "redirect:/user";
        }


}
