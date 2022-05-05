<%@ page import="com.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 22344
  Date: 2022/4/15
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="jq/jquery-3.5.1.min.js"></script>
</head>
<body>
<h2>
    <style>
        .table{width: 500px;margin: 0 auto}
    </style>
</h2>
<%
    List<User> list  = (List<User>) request.getAttribute("list");
%>

<nav class="navbar navbar-default" style="padding: 10px;height: 25px"><a href="myjsp" style="line-height: 25px;margin-right: 50px">首页</a><a href="useradd" style="line-height: 25px">点击添加</a></nav>
<table class="table table table-striped" id="table">
<%for (int i = 0; i < list.size(); i++) {%><tr>
        <td><%= list.get(i).getUserId()%></td>
        <td><%= list.get(i).getRealName()%></td>
        <td><%= list.get(i).getUserName()%></td>
        <td><%= list.get(i).getUserPwd()%></td>
        <td><a href="useredit?id=<%=list.get(i).getUserId()%>">编辑</a>||<a href="dodeleteuser?id=<%=list.get(i).getUserId()%>">删除</a></td>
</tr>
<%}%>
</table>
</body>
</html>
