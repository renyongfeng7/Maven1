<%@ page import="com.bean.NewsType" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/5
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="jq/jquery-3.5.1.min.js"></script>
    <style>
        .table{width: 500px;margin: 0 auto}
    </style>
</head>
<body >
<nav class="navbar navbar-default" style="padding: 10px;height: 25px"><a href="myjsp" style="line-height: 25px;margin-right: 50px">首页</a><a href="typeadd" style="line-height: 25px">点击添加</a></nav>
<table class="table table table-striped" id="table">
       <%
         List<NewsType> list = (List<NewsType>) request.getAttribute("list");
       %>
    <tr>
        <td>类别ID</td>
        <td>类别名称</td>
        <td>操作</td>
    </tr>
    <%for(int i =0;i< list.size();i++){%>
    <tr>
        <td><%=list.get(i).getTypeId() %></td>
        <td><%=list.get(i).getTypeName()%></td>
        <td><a href="#">编辑</a>||<a href="dodeletetype?id=<%=list.get(i).getTypeId()%>">删除</a></td>
    </tr><%}%>

</table>
</body>
</html>
