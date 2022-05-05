package com.controller;


import com.bean.NewsType;
import com.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NewsTypeController {

@Autowired
public NewsTypeService newsTypeService;

    @RequestMapping("/newstype")
    public String newstype (Model model){
        System.out.println("newstype");
        List<NewsType> list = newsTypeService.selectAll();
        System.out.println(list);
        model.addAttribute("list",list);
        return "newstypee";
    }

    @RequestMapping("dodeletetype")
    public String delete(String id){
        System.out.println("dedelete");
        int id1 = Integer.parseInt(id);
        newsTypeService.deleteById(id1);
        return "redirect:/newstype";
    }
    @RequestMapping("typeadd")
    public String typeadd(){

        return "typeadd";
    }

    @RequestMapping("doaddtype")
    public String doaddtype(String typeName){

        NewsType  newsType = new NewsType();
        newsType.setTypeName(typeName);
        newsTypeService.insert(newsType);

        return "redirect:/newstype";
    }
}
