<%--
  Created by IntelliJ IDEA.
  User: QQQ
  Date: 2019/1/3
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
    <title>首页</title>
</head>
<link type="text/css" rel="stylesheet" href="css/home.css" >
<script src="jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
<script src="jquery3.3.1-jqueryui1.12.1/jquery-ui.js" charset="utf-8"></script>
<body>
    <div class="header">
        <div class="head_txt">学籍信息</div>
        <div class="logout">登出</div>
    </div>
    <div class="ct">
        <div class="navigation">
            <div class="navigation_li">
                <a href="javascript:void(0);" onclick="jbxx_show()">基本信息</a>
            </div>
            <div class="navigation_li">
                <a href="javascript:void(0);" onclick="xjxx_show()">学籍信息</a>
            </div>
            <div class="navigation_li">
                 <a href="javascript:void(0);" onclick="kcxx_show()">课程信息</a>
            </div>
            <div class="navigation_li">
                <a href="javascript:void(0);" onclick="cjxx_show()">成绩信息</a>
            </div>
        </div>
        <div id="content_box">
            <div id="jbxx" style="display: block">
                <div class="content_box_title">基本信息</div>
                <div class="information">
                </div>
            </div>
            <div id="xjxx" style="display: none">
                <div class="content_box_title">学籍信息</div>
            </div>
            <div id="kcxx" style="display: none">
                <div class="content_box_title">课程信息</div>
            </div>
            <div id="cjxx" style="display: none">
                <div class="content_box_title">成绩信息</div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</body>
<script>
    function jbxx_show() {
        $("#jbxx").css("display","block");
        $("#xjxx").css("display","none");
        $("#kcxx").css("display","none");
        $("#cjxx").css("display","none");
    }
    function xjxx_show() {
        $("#jbxx").css("display","none");
        $("#xjxx").css("display","block");
        $("#kcxx").css("display","none");
        $("#cjxx").css("display","none");
    }
    function kcxx_show() {
        $("#jbxx").css("display","none");
        $("#xjxx").css("display","none");
        $("#kcxx").css("display","block");
        $("#cjxx").css("display","none");
    }
    function cjxx_show() {
        $("#jbxx").css("display","none");
        $("#xjxx").css("display","none");
        $("#kcxx").css("display","none");
        $("#cjxx").css("display","block");
    }

</script>
</html>
