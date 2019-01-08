<%--
  Created by IntelliJ IDEA.
  User: QQQ
  Date: 2019/1/3
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
    <title>首页</title>

    <script src="jquery3.3.1-jqueryui1.12.1/jquery-3.3.1.js" charset="utf-8"></script>
    <script src="jquery3.3.1-jqueryui1.12.1/DataTables-1.10.15/media/js/jquery.js" charset="utf-8"></script>
    <script src="jquery3.3.1-jqueryui1.12.1/DataTables-1.10.15/media/js/jquery.dataTables.js" charset="utf-8"></script>
    <script src="jquery3.3.1-jqueryui1.12.1/jquery-ui.js" charset="utf-8"></script>

    <link rel="stylesheet" href="jquery3.3.1-jqueryui1.12.1/DataTables-1.10.15/media/css/jquery.dataTables.css" />
    <link rel="stylesheet" href="jquery3.3.1-jqueryui1.12.1/jquery-ui.css" />
    <link type="text/css" rel="stylesheet" href="css/home.css" >

</head>

<%
    List<Student> ls = (ArrayList<Student>)request.getAttribute("StudentInfoList");
    int flag = (int)request.getAttribute("Flag");
%>

<body>
    <div class="header">
        <div class="head_txt">学籍信息</div>
        <div class="logout">登出</div>
    </div>
    <div class="ct">
        <div class="navigation">
            <div class="navigation_li">
                <a href="<%=basePath%>get_all_students" onclick="jbxx_show()">基本信息</a>
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
                    <div style="height: 50px;width: 100%;margin-bottom: 10px;position: relative"><div id="export_div">导出</div><input type="file" id="export" ></div>
                    <table id="content_table" style="white-space: nowrap;">
                        <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>年龄</th>
                            <th>性别</th>
                            <th>学院</th>
                            <th>专业</th>
                            <th>班级</th>
                            <th>生日</th>
                            <th>入学时间</th>
                            <th>年级</th>
                            <th>已获学分</th>
                            <th>生源</th>
                            <th>民族</th>
                            <th>学生类别</th>
                            <th>政治面貌</th>
                            <th>平均绩点</th>
                            <th>学生状态</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%
                                if(ls != null && flag == 1){
                                    for(Student i : ls){
                            %>
                                        <tr>
                                            <td><%= i.getId() %></td>
                                            <td><%= i.getName() %></td>
                                            <td><%= i.getAge() %></td>
                                            <td><%= i.getSex() %></td>
                                            <td><%= i.getInstitute() %></td>
                                            <td><%= i.getMajor() %></td>
                                            <td><%= i.getStudentClass() %></td>
                                            <td><%= i.getBirthday() %></td>
                                            <td><%= i.getStartTime() %></td>
                                            <td><%= i.getGrade() %></td>
                                            <td><%= i.getCredit() %></td>
                                            <td><%= i.getSource() %></td>
                                            <td><%= i.getNationality() %></td>
                                            <td><%= i.getType() %></td>
                                            <td><%= i.getPoliticalStatus() %></td>
                                            <td><%= i.getGpa() %></td>
                                            <td><%= i.getStatus() %></td>
                                        </tr>
                            <%
                                }}
                            %>


                            <%--<c:if test="${StudentInfoList==null}">--%>
                                <%--<tr>--%>
                                    <%--<td>空</td>--%>
                                    <%--<td>空</td>--%>
                                    <%--<td>空</td>--%>
                                <%--</tr>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${StudentInfoList!=null}">--%>
                                <%--<c:forEach items="${StudentInfoList}" var="t">--%>
                                    <%--<tr>--%>
                                        <%--<td>${t.id}</td>--%>
                                        <%--<td>${t.name}</td>--%>
                                        <%--<td>${t.age}</td>--%>
                                    <%--</tr>--%>
                                <%--</c:forEach>--%>
                            <%--</c:if>--%>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="xjxx" style="display: none">
                <div class="content_box_title">学籍信息</div>
                <div>



                </div>
            </div>
            <div id="kcxx" style="display: none">
                <div class="content_box_title">课程信息</div>
                <div>



                </div>
            </div>
            <div id="cjxx" style="display: none">
                <div class="content_box_title">成绩信息</div>
                <div>



                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</body>
<script>
    $(document).ready( function () {
        $('#content_table').DataTable({
            scrollX: true,
            //scrollY: "300px",
            bAutoWidth:true,
        });
    } );

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
