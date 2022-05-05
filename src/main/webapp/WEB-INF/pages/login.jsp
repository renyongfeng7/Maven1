<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>登录</title>
	<style type="text/css">
	</style>
</head>
<body>
<%
	/*  application多用户之s间数据共享*/
	int count =0;
	if(application.getAttribute("count")!=null){
		count =(Integer)application.getAttribute("count");
		count++;
	}else{
		count=1;
	}
	application.setAttribute("count", count);

	String userName="";
	String userPwd="";
	Cookie[] cos=request.getCookies();
	if(cos!=null){
		for(Cookie ck : cos){
			if(ck.getName().equals("userName")){
				userName = ck.getValue();
			}else if(ck.getName().equals("userPwd")){
				userPwd = ck.getValue();
			}
		}
	}
%>
<div style="width: 300px;margin: 0 auto;">
	<span style="margin-left: 90px;font-weight: bolder;font-size: 20px;">用户登录</span>
	<div style="margin: 20px"></div>
	<form action="login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName" value= "<%=request.getParameter("userName")==null?userName:request.getParameter("userName")%>"></td><%----%>
			</tr>

			<tr>
				<td>密码</td>
				<td><input type="password" name="userPwd" value="<%=request.getParameter("userPwd")==null?userPwd:""%>"></td><%--<%=request.getParameter("userPw")==null?userPw:""%>--%>
			</tr>
		</table>
		<input type="checkbox" name = "hobby" value="篮球">篮球
		<input type="checkbox" name = "hobby" value="网球">网球
		<input type="checkbox" name = "hobby" value="羽毛球">羽毛球</br>
		<input type="checkbox" name="remember">记住密码
		<input type="submit" value="登录">
		<h3>${error!=null?error:""}</h3>
		<h4>
			<%--<%= request.getAttribute("error")!=null?request.getAttribute("error"):""%>--%>

			sessionid：<%= session.getId()%>
            最大失效时间：<%= session.getMaxInactiveInterval() %>秒
		</h4>
	</form>

</div>
</body>
</html>
