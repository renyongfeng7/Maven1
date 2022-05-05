<%@page import="com.bean.*"%>
<%@page import="com.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="jq/jquery-3.5.1.min.js"></script>
</head>
<body>
<div style="width: 500px;margin: 0 auto;height: 1000px;margin-top: 50px" >
    <nav class="navbar navbar-default" style="padding: 10px;height: 25px;line-height: 25px;font-size: 20px;font-weight: bolder;">用户添加</nav>
    <form class="form-horizontal" action="doadduser" method="post" id="sub" >
        <div class="form-group">
            <label  class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control "  id="realName" placeholder="输入姓名" name="realName">
                <span style="color: red;font-weight: bolder;">${error1!=null?error1:""}<%--<%= request.getAttribute("error1")!=null?request.getAttribute("error1"):""%>--%></span>
            </div>
        </div>
        <div class="form-group ">
            <label  class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10 ">
                <input type="text" class="form-control "  id="userName" placeholder="输入用户名" name="userName">
                <span style="color: red;font-weight: bolder;">${error1!=null?error1:""}<%--<%= request.getAttribute("error1")!=null?request.getAttribute("error1"):""%>--%></span>
            </div>
        </div>
        <div class="form-group ">
            <label  class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10 ">
                <input type="text" class="form-control "  id="userPwd" placeholder="输入密码" name="userPwd">
                <span style="color: red;font-weight: bolder;">${error1!=null?error1:""}<%--<%= request.getAttribute("error1")!=null?request.getAttribute("error1"):""%>--%></span>
            </div>
        </div>
        <input type="button" value="返回" id="back" class="btn btn-default">
        <input type="submit" value="保存" class="btn btn-success" id="subm">
    </form>
    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
    <span id="inputSuccess2Status" class="sr-only">(success)</span>
</div>

<script type="text/javascript">
    /* 返回首页 */
    $("#back").click(function(){
        history.back("MyJsp.jsp");
    });
</script>
<script type="text/javascript">
    $("#subm").click(function(){

        var check = null;
        /*验证标题是否为空*********/
        var newsTitle = $("#newsTitle").val();
        if(newsTitle==""){
            $("#newsTitle").parent().addClass("has-error");
            check=  false;
        }else{
            $("#newsTitle").parent().removeClass("has-error").addClass("has-success");
            check = true;
        }
        /*验证类型是否为空**********/
        var newsType = $("#newsType").val();
        if(newsType==""){
            $("#newsType").parent().addClass("has-error");
            check=  false;
        }else{
            $("#newsType").parent().removeClass("has-error").addClass("has-success");
            check = true;
            /*验证内容是否为空**********/
            var newsContent = $("#newsContent").val();

            if(newsContent==""){
                $("#newsContent").parent().addClass("has-error");
                check=  false;

            }else{
                $("#newsContent").parent().removeClass("has-error").addClass("has-success");
                check = true;
            }
            /*验证发布时间是否为空**********/
            var newsTitle = $("#sendTime").val();
            if(newsTitle==""){
                $("#sendTime").parent().addClass("has-error");
                check=  false;

            }else{
                $("#sendTime").parent().removeClass("has-error").addClass("has-success");
                check = true;
            }

            if(check!=false){
                $("#sub").submit();
            }
        }

    });

</script>

</body>
</html>
