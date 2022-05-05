package com.controller;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/mv")
    public ModelAndView mv(){
        Map<String,Object> model = new HashMap<>();
        model.put("name","springMVC");
        return new ModelAndView("login",model);
    }

    @RequestMapping("/view")
    public String view( Model model){
    model.addAttribute("name","Model");
        return "login";
    }

    @RequestMapping("/ssm")
    public String ssm( Model model){
        model.addAttribute("list",this.userService.selectAll());
        return "login";
    }

}
