<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.bean.*"%>
<%@ page import="com.service.impl.NewsInforServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE >
<html>

<head>
	<style type="text/css">
		*{margin: 0}
		.left{background-color: #8c8c8c;color: white;width: 150px;float: left;padding: 10px;height: 300px}
		.left li{list-style: none;}
		.right{color: white;float: left;height: 250px;padding: 10px;}
	</style>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<%int pageno = Integer.parseInt(request.getParameter("pageno")==null?"1":request.getParameter("pageno"));%>

<h4>你好，${login.realName},${login["realName"]}</h4>
<div class="left">
	<ul>
		<li><a href="myjsp">新闻管理</a></li>
		<li><a href="newstype">类别管理</a></li>
		<li><a href="user">用户管理</a></li>
	</ul>
</div>
<div class="right">
		<nav class="navbar navbar-default" style="padding: 10px;height: 25px"><a href="newsadd" style="line-height: 25px">点击添加</a></nav>
	<!-- 表格 -->
	<table class="table table table-striped" style="width: 1000px">
		<tr>
			<td>新闻ID</td>
			<td>新闻标题</td>
			<td>图片</td>
			<td>新闻类别</td>
			<td>发布人</td>
			<td>发布时间</td>
			<td>编辑</td>
		</tr>
		<%--jstl循环--%>
		<c:forEach items="${page.list}" var="obj">
			<tr>
				<td>${obj.newsId}</td>
				<td>${obj.newsTitle}</td>
				<td>${obj.newsImg}</td>
				<td>${obj.newsType.typeName}</td>
				<td>${obj.sendUser.realName}</td>
				<td>
					<fmt:formatDate value="${obj.sendTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
				</td>
					<td><a href="newsdelete?id=${obj.newsId}">删除</a>|<a href="newsedit?id=${obj.newsId}">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
	<!-- 分页 -->
	<h5 style="color: #0f0f0f">共${page.count}条信息</h5>
	<div style="width: 500px;margin: 0 auto">
	<ul class="pagination">
		<li>
			<a href="myjsp?pageno=1"aria-label="Previous">
				<span aria-hidden="true">首页</span>
			</a>
			<!--url传参注意空格-->
		<li><a href="myjsp?pageno=${ ((page.pageno)-1)<1?page.pageno: (page.pageno-1)}" >上一页</a></li>
		<li><a href="#">第${page.pageno}页/共${page.pagetotal}页</a></li>
		<%--<li><a href="myjsp?pageno=<%=(pageno+1)>10?pageno:(pageno+1)%>" >下一页</a></li>--%>
		<li><a href="myjsp?pageno=${(page.pageno+1)>page.pagetotal?page.pagetotal:(page.pageno+1)}" >下一页</a></li>
		<li>
			<a href="myjsp?pageno=${page.pagetotal}" aria-label="Next">
				<span aria-hidden="true">尾页>></span>
			</a>
	</ul></div>
	<nav class="navbar navbar-default" style="padding: 10px;height: 25px"><h5>[<a href="logout">退出登录</a>]</h5></nav>
</div>

</body>
</html>
