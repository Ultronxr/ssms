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
    <script src="js/home.js" type="text/javascript"></script>

</head>

<%
    List<Student> ls = (ArrayList<Student>)request.getAttribute("StudentInfoList");
    int flag = (int)request.getAttribute("Flag");

%>

<body>
    <div class="header">
        <div class="head_txt">学籍信息</div>
        <div class="logout"><a href="<%=basePath%>" style="text-decoration:none; color:#000000;">登出</a></div>
    </div>
    <div class="ct">
        <div class="navigation">
            <div class="navigation_li">
                <a href="<%=basePath%>get_all_students" onclick="jbxx_show()">基本信息</a>
            </div>
            <%--<div class="navigation_li">--%>
                <%--<a href="javascript:void(0);" onclick="xjxx_show()">学籍信息</a>--%>
            <%--</div>--%>
            <div class="navigation_li">
                 <a href="javascript:void(0);" onclick="kcxx_show()">课程信息</a>
            </div>
            <%--<div class="navigation_li">--%>
                <%--<a href="javascript:void(0);" onclick="cjxx_show()">成绩信息</a>--%>
            <%--</div>--%>
        </div>
        <div id="content_box">
            <div id="jbxx" style="display: block">
                <div class="content_box_title">基本信息
                    <div style="height: 50px;width: 100%;margin-bottom: 10px;position: relative">
                        <div id="export_div">导入</div>
                        <form action="import.jhtml" method="post" enctype="multipart/form-data">
                            <input type="file" name="file" id="export" onchange="upload()">
                        </form>
                    </div>
                </div>
                <div class="information">

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
                                    for(int i=0;i<ls.size();i++){
                            %>
                                        <tr id="tr<%=i%>" ondblclick="getxjxx(<%=i%>)";>
                                            <td><%= ls.get(i).getId() %></td>
                                            <td><%= ls.get(i).getName() %></td>
                                            <td><%= ls.get(i).getAge() %></td>
                                            <td><%= ls.get(i).getSex() %></td>
                                            <td><%= ls.get(i).getInstitute() %></td>
                                            <td><%= ls.get(i).getMajor() %></td>
                                            <td><%= ls.get(i).getStudentClass() %></td>
                                            <td><%= ls.get(i).getBirthday() %></td>
                                            <td><%= ls.get(i).getStartTime() %></td>
                                            <td><%= ls.get(i).getGrade() %></td>
                                            <td><%= ls.get(i).getCredit() %></td>
                                            <td><%= ls.get(i).getSource() %></td>
                                            <td><%= ls.get(i).getNationality() %></td>
                                            <td><%= ls.get(i).getType() %></td>
                                            <td><%= ls.get(i).getPoliticalStatus() %></td>
                                            <td><%= ls.get(i).getGpa() %></td>
                                            <td><%= ls.get(i).getStatus() %></td>
                                        </tr>
                            <%
                                }}
                            %>

                        </tbody>
                    </table>
                    <%--<button onclick="addTest()">添加测试行</button>--%>
                    <%--<button onclick="delTest()">删除测试行</button>--%>
                    <br/><br/><br/><br/><br/><br/>
                </div>
            </div>
            <div id="xjxx" style="display: none">
                <div class="content_box_title">学籍信息
                    <input type="button" id="update_xjxx" value="修改" class="ctbutton" onclick="update_xjxx_b()">
                    <input type="button" id="del_xjxx" value="删除" class="ctbutton" onclick="del_xjxx()" style="margin-right: 20px">
                </div>
                <div id="del_xj" style="display: none;width: 300px;height: 130px;padding: 20px 10px 20px 10px">
                    <span style="display:inline-block; float: left;margin-left: 5px;margin-top: 5px;height: 40px;font-size: 20px;color: black;line-height: 40px;margin-left: 20px;">是否删除？请谨慎操作！</span>
                    <div style="clear:both"></div>
                    <button class="ctbutton" onclick="del_xjxx_b()" style="float: left;left: 15px;margin-left: 40px;margin-top: 5px">确认</button>
                    <button class="ctbutton" onclick="del_xjxx_b_cancel()" style="float: left;margin-left: 5px;margin-top: 5px">取消</button>
                </div>
                <div class="information">
                    <div class="information_line">
                        <div class="block">学号</div>
                        <input type="text" class="information_ip" id="sid">
                        <div class="block">姓名</div>
                        <input type="text" class="information_ip" id="sname">
                        <div class="block">年龄</div>
                        <input type="text" class="information_ip" id="sage">
                    </div>
                    <div class="information_line">
                        <div class="block">性别</div>
                        <input type="text" class="information_ip" id="ssex">
                        <div class="block">学院</div>
                        <input type="text" class="information_ip" id="sinstitute">
                        <div class="block">专业</div>
                        <input type="text" class="information_ip" id="smajor">
                    </div>
                    <div class="information_line">
                        <div class="block">班级</div>
                        <input type="text" class="information_ip" id="sclass">
                        <div class="block">生日</div>
                        <input type="text" class="information_ip" id="sbirthday">
                        <div class="block" style="margin-left: 81px;">入学时间</div>
                        <input type="text" class="information_ip" id="sstartTime">
                    </div>
                    <div class="information_line">
                        <div class="block">年级</div>
                        <input type="text" class="information_ip" id="sgrade">
                        <div class="block" style="margin-left: 81px;">已获学分</div>
                        <input type="text" class="information_ip" id="scredit">
                        <div class="block" >生源</div>
                        <input type="text" class="information_ip" id="ssource">
                    </div>
                    <div class="information_line">
                        <div class="block">民族</div>
                        <input type="text" class="information_ip" id="snationality">
                        <div class="block" style="margin-left: 81px;">学生类别</div>
                        <input type="text" class="information_ip" id="stype">
                        <div class="block" style="margin-left: 81px;">政治面貌</div>
                        <input type="text" class="information_ip" id="spoliticalStatus">
                    </div>
                    <div class="information_line">
                        <div class="block" style="margin-left: 81px;">平均绩点</div>
                        <input type="text" class="information_ip" id="sgpa">
                        <div class="block" style="margin-left: 81px;">学生状态</div>
                        <input type="text" class="information_ip" id="sstatus">
                        <button class="ctbutton" style="width: 300px;margin-right: 200px" onclick="search_cj()">查询学生成绩</button>
                    </div>
                </div>
            </div>
            <div id="kcxx" style="display: none">
                <div class="content_box_title">课程信息</div>
                <div class="information">
                    <table id="kcxx_table" style="white-space: nowrap;">
                        <thead>
                            <tr>
                                <th>课程编号</th>
                                <th>课程名称</th>
                                <th>学院</th>
                                <th>开课学年</th>
                                <th>学期</th>
                                <th>分类</th>
                                <th>学分</th>
                                <th>教师</th>
                                <th>上课时间</th>
                                <th>上课地点</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="kcBody">

                        </tbody>
                    </table>

                </div>
            </div>
            <div id="cjxx" style="display: none">
                <div class="content_box_title">成绩信息</div>
                <div id="export_div_cj" style="top: 5px" onclick="">导出</div>
                <div class="information">
                    <table id="cjxx_table" style="white-space: nowrap;">
                        <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>学年</th>
                            <th>学期</th>
                            <th>专业</th>
                            <th>班级</th>
                            <th>学分</th>
                            <th>成绩</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="cjBody">

                        </tbody>
                    </table>
                </div>
            </div>
            <div id="grcjxx" style="display: none">
                <div class="content_box_title">成绩信息</div>
                <div id="export_div_grcj" style="top: 5px" onclick="">导出</div>
                <div class="information">
                    <table id="grcjxx_table" style="white-space: nowrap;">
                        <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>班级</th>
                            <th>课程编号</th>
                            <th>课程名</th>
                            <th>课程类别</th>
                            <th>上课老师</th>
                            <th>学年</th>
                            <th>学期</th>
                            <th>学分</th>
                            <th>成绩</th>
                            <%--<th>操作</th>--%>
                        </tr>
                        </thead>
                        <tbody id="grcjBody">

                        </tbody>
                    </table>
                </div>
            </div>
            <div id="up_cj" style="display: none;width: 300px;height: 130px;padding: 20px 10px 20px 10px">
                <span style="height: 40px;font-size: 20px;color: black;line-height: 40px;margin-left: 20px;">请输入成绩</span>
                <input type="text" id="grade" style="height: 40px;line-height: 40px;font-size: 20px;" placeholder="请输入0-100的整数">
                <input type="text" id="sid_up" style="display: none">
                <input type="text" id="cid_up" style="display: none">
                <input type="text" id="sy_up" style="display: none">
                <input type="text" id="sm_up" style="display: none">
                <button class="ctbutton" onclick="update_cjxx_b()" style="float: none;margin-left: 180px;margin-top: 20px">修改</button>
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

            // processing: true,
            // serverSide: true,
            // sPaginationType: "full_numbers",
            // sAjaxDataProp: "data", //指定数据源
            // ajax: "http://localhost:8999/ssms/get_all_students",
            // columns: [
            //     {"data": "id"},
            //     {"data": "name"},
            // ],

            language:{
                oPaginate:{
                    sFirst:"首页",
                    sPrevious:"上一页",
                    sNext:"下一页",
                    sLast:"尾页"
                },
                sSearch:"搜索",
                sInfoEmpty: "当前显示第 0 至 0 项，共 0 项",
                sInfo: "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项",
                sLengthMenu: "每页 _MENU_ 项",
            }
        });

    } );


</script>
</html>
