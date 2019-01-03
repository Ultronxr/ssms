<%--
  Created by IntelliJ IDEA.
  User: QQQ
  Date: 2019/1/2
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<script src="jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
<script src="jquery3.3.1-jqueryui1.12.1/jquery-ui.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="css/login.css" >
<body>
    <div class="header">
        <div class="head_txt">学籍管理系统</div>
    </div>
    <div class="mainbody">
        <div id="login" class="login" style="">
            <%--<div class="login_icon"></div>--%>
            <form action="<%=basePath %>login" class="login_form" method="post">
                <div class="ctitle">用户登录</div>
                <div class="content">
                    <div class="comm">
                        <i class="user_icon"></i>
                        <input type="text" class="text" name="username" placeholder="请输入用户名"/>
                    </div>
                    <div class="comm">
                        <i class="pwd_icon"></i>
                        <input type="password" class="text" name="password" placeholder="请输入密码"/>
                    </div>
                    <input type="submit" class="button" value="登录">
                </div>
            </form>
        </div>
    </div>
    <div class="footer"></div>
</body>
</html>
