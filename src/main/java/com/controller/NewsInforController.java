package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.NewsInfor;
import com.bean.NewsType;
import com.bean.Page;
import com.bean.User;
import com.service.NewsInforService;
import com.service.NewsTypeService;
import com.service.UserService;
import com.service.impl.NewsInforServiceImpl;
import com.service.impl.NewsTypeServiceImpl;
import com.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Controller

public class NewsInforController {
    @Autowired
    public NewsInforService newsInforService;

    @ExceptionHandler(value = Exception.class)

    @RequestMapping("/myjsp")
    public String myjsp(@RequestParam(value = "pageno",defaultValue = "1") int pageno, Model model) throws IOException {
        /*pageSize默认值5*/
        int pageSize = 5;
        /*总页数*/
        int pagetotal;
        /*总条数*/
        int count = newsInforService.count();
        /*计算总页数*/
        if(count%pageSize==0){
            pagetotal = count/pageSize;
        }else{
            pagetotal=(count/pageSize)+1;
        }
        /*调用方法分页查询*/
        List<NewsInfor> list = newsInforService.selectByPage((pageno-1)*pageSize,pageSize);
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        Page page = new Page(pageno,count,pagetotal,list);
       /* model.addAttribute("list",list);
       model.addAttribute("pageno",pageno);
       model.addAttribute("pagetotal",pagetotal);
       model.addAttribute("count",count);*/
        model.addAttribute("page",page);
        return "MyJsp";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "indexx";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        session.removeAttribute("login");
        session.invalidate();
        return "redirect:/login";
    }

    /*执行删除操作，跳转首页*/
    @RequestMapping("/newsdelete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        newsInforService.deleteById(id);
        return "redirect:/myjsp";
    }

    /*携带数据，进入编辑页面*/
    @RequestMapping("/newsedit")
    public String edit(int id,Model model) throws IOException {

        NewsInfor newsInfor = newsInforService.selectById(id);
        List<NewsType> list =newsTypeService.selectAll();
        model.addAttribute("newsInfor",newsInfor);
        model.addAttribute("list",list);
        return "edit";

    }
    /*执行编辑操作，跳转到首页*/
    @RequestMapping("/doedit")
    public String doedit(int sendId,Model model,String newsTitle,String newsType,String newsContent,String sendTime,String sendUser,HttpServletRequest request) throws IOException, ParseException {

        newsTitle = new String(request.getParameter("newsTitle").getBytes("ISO-8859-1"), "utf-8");
        newsContent = new String(request.getParameter("newsContent").getBytes("ISO-8859-1"), "utf-8");
        NewsInfor newsInfor = new NewsInfor();
        newsInfor.setNewsContent(newsContent);
        newsInfor.setNewsTitle(newsTitle);
        /*赋值类别*/
        NewsType newsType1= new NewsType();
        newsType1.setTypeId(Integer.parseInt(newsType));
        newsInfor.setNewsType(newsType1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        newsInfor.setSendTime(sdf.parse(sendTime));
        User user = new User();
        user.setUserId(((User)request.getSession().getAttribute("login")).getUserId());
        newsInfor.setSendUser(user);
        newsInfor.setNewsId(sendId);
        int i =  newsInforService.updateById(newsInfor);
        System.out.println(i+"+++++++++++"+((User)request.getSession().getAttribute("login")).getUserId());
        return "redirect:/myjsp";
    }

    @Autowired
    private NewsTypeService newsTypeService;
    /*携带类型数据，到新闻添加页面*/
    @RequestMapping("/newsadd")
    public String newsadd(Model model) throws IOException {
        List<NewsType> list = newsTypeService.selectAll();
        model.addAttribute("list",list);
        return "newsadd";
    }
    /*执行添加操作，跳转到首页*/

    @RequestMapping(value = "/doadd",method = RequestMethod.POST)
    public String doadd(Model model,HttpServletRequest request, String newsType, String sendTime, MultipartFile upload,String newsTitle,String newsContent) throws UnsupportedEncodingException, ParseException {
        NewsInfor newsInfor = new NewsInfor();
        request.setCharacterEncoding("UTF-8");
        System.out.println("newsTitle"+newsTitle);
        // newsTitle = new String(request.getParameter("newsTitle").getBytes("ISO-8859-1"), "utf-8");
        //String newsContent = new String(request.getPa
        // rameter("newsContent").getBytes("ISO-8859-1"), "utf-8");
        /*判断文件是否为空*/
        boolean f = true;
        if(!upload.isEmpty()){
            String uploadname = upload.getOriginalFilename();
            String sub = uploadname.substring( uploadname.lastIndexOf("."));
            /*判断文件类型*/
            if(sub.equals(".jpg")||sub.equals(".png")){
                /*重命名文件*/
                uploadname = UUID.randomUUID()+uploadname;
                /*创建文件夹*/
                String realpath=  request.getSession().getServletContext().getRealPath("/upload");
                File file = new File(realpath,uploadname);
                /*判断文件夹是否存在*/
                if(!file.exists()){
                    file.mkdirs();
                }
                try {
                    /*文件上传*/
                    upload.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newsInfor.setNewsImg(uploadname);
            }else{
                String type ="文件";
                System.out.println("文件类型");
                f = false;

            }
        }else{
            System.out.println("文件为空");

        }
        newsInfor.setNewsTitle(newsTitle);
        NewsType newsType1= new NewsType();
        newsType1.setTypeId(Integer.parseInt(newsType));
        newsInfor.setNewsType(newsType1);

        newsInfor.setNewsContent(newsContent);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        newsInfor.setSendTime(sdf.parse(sendTime));
        User user = new User();
        user.setUserId(((User)request.getSession().getAttribute("login")).getUserId());
        newsInfor.setSendUser(user);
        newsInforService.insert(newsInfor);
        return "redirect:/myjsp";

    }
}
