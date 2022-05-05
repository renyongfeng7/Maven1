package com.intercept;

import com.bean.Root;
import com.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Interceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        response.setContentType("text/html;charset=UTF-8");
        String URI_request = request.getRequestURI();
        System.out.println(URI_request);
        List list = (List) request.getSession().getAttribute("listRoolFun");
        System.out.println("所用用户权限list:::" + list);
        boolean needControl = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(URI_request)) {
                System.out.println("有权限");
                needControl = true;
                break;
            }
        }
        if (!needControl) {
            response.getWriter().write("<script>\n" +
                    "\t\talert('权限不足，删除失败')\n" +
                    "\t\tlocation.href='myjsp'\n" +
                    "\t</script>");
            return false;
        }else{
            return true;
        }
    }





}
