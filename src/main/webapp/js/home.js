var strFullPath = window.document.location.href;
var strPath = window.document.location.pathname;
var pos = strFullPath.indexOf(strPath);
var prePath = strFullPath.substring(0, pos);
var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
var basePath = prePath;
basePath = prePath + postPath;
var flag_kc = 0;
var flag_cj = 0;
function upload() {
    var fileObj = document.getElementById("export").files[0];
    if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
        alert("请选择文件");
        return;
    }
    var formData=new FormData();
    formData.append("file",fileObj);
    // console.log(formData);
    $.ajax({
        type:"post",
        url:"import.jhtml",
        data: formData,
        sync:false,
        cache: false,
        processData: false,
        contentType : false,

        dataType: "json",
        beforeSend:function(){
            console.log("正在导入，请稍候");
        },
        success:function(data){
            alert("导入成功！");
        },
        error:function (data) {
            alert("导入失败！");
        }
    });
}

function update_xjxx_b() {
    var sid = $("#sid").val(),
        sname = $("#sname").val(),
        sage = $("#sage").val(),
        ssex = $("#ssex").val(),
        sinstitute = $("#sinstitute").val(),
        smajor = $("#smajor").val(),
        sclass = $("#sclass").val(),
        sbirthday = $("#sbirthday").val(),
        sstartTime = $("#sstartTime").val(),
        sgrade = $("#sgrade").val(),
        scredit = $("#scredit").val(),
        ssource = $("#ssource").val(),
        snationality = $("#snationality").val(),
        stype = $("#stype").val(),
        spoliticalStatus = $("#spoliticalStatus").val(),
        sgpa = $("#sgpa").val(),
        sstatus = $("#sstatus").val();
    
    if(sid==""||sname==""||sage==""||ssex==""||sinstitute==""||smajor==""||sclass==""||sbirthday==""||sstartTime==""||sgrade==""||scredit==""||ssource==""||snationality==""||stype==""||spoliticalStatus==""||sgpa==""||sstatus==""||
        sid==null||sname==null||sage==null||ssex==null||sinstitute==null||smajor==null||sclass==null||sbirthday==null||sstartTime==null||sgrade==null||scredit==null||ssource==null||snationality==null||stype==null||spoliticalStatus==null||sgpa==null||sstatus==null){
        alert("请填写完整所有信息！不能为空！");
        return;
    }

    var jsondata = {sid:sid, sname:sname, sage:sage,  ssex :ssex,  sinstitute :sinstitute,  smajor :smajor,  sclass :sclass,  sbirthday :sbirthday,  sstartTime :sstartTime,  sgrade :sgrade,  scredit :scredit,  ssource :ssource,  snationality :snationality,  stype :stype,  spoliticalStatus :spoliticalStatus,  sgpa :sgpa,  sstatus :sstatus};

    $.ajax({
        type:'post',
        url:'updateInfos?Category=UpdateStudentInfo',
        //contentType: "json",
        data: jsondata,
        dataType : 'json',
        async: false,
        success:function(data){
                alert("修改成功！");
        },
        error:function () {
            alert("success！");
        }

    });

}

function update_cjxx_b(){
    var student_id = $("#sid_up").val(),
        course_id = $("#cid_up").val(),
        year = $("#sy_up").val(),
        semester = $("#sm_up").val(),
        score = $("#grade").val();
    console.log(student_id+" "+course_id+" "+score);
    var reg1 = "/^[0-9]{1,3}$/";
    // if(!reg1.test(score)){
    //     alert("请输入1-100之间的数字！");
    //     return;
    // }
    if(score < 0 || score > 100){
        alert("请输入1-100之间的数字！");
        return;
    }

    var jsondata = {student_id:student_id, course_id:course_id, score:score};

    $.ajax({
        type:'post',
        url:'updateInfos?Category=UpdateScore',
        //contentType: "json",
        data: jsondata,
        dataType : 'json',
        async: false,
        success:function(data){
            alert("修改成功！");
        },
        error:function () {
            alert("success！");
        }
    });
    $("#up_cj").dialog("close");
    getkcxx(course_id,year,semester);
}

function jbxx_show() {
    $("#jbxx").css("display","block");
    $("#xjxx").css("display","none");
    $("#kcxx").css("display","none");
    $("#cjxx").css("display","none");
    $("#grcjxx").css("display","none");
}
function xjxx_show() {
    $("#jbxx").css("display","none");
    $("#xjxx").css("display","block");
    $("#kcxx").css("display","none");
    $("#cjxx").css("display","none");
    $("#grcjxx").css("display","none");
}
//课程信息的显示
function kcxx_show() {
    $("#jbxx").css("display","none");
    $("#xjxx").css("display","none");
    $("#kcxx").css("display","block");
    $("#cjxx").css("display","none");
    $("#grcjxx").css("display","none");
    var url = basePath+"/get_all_courses";

    $('#kcxx_table').DataTable({
        scrollX: true,
        //scrollY: "300px",
        bAutoWidth:true,
        ajax: url,
        bDestroy: true,
        columns:[
            {"data":"id"},
            {"data":"name"},
            {"data":"institute"},
            {"data":"school_year"},
            {"data":"semester"},
            {"data":"category"},
            {"data":"credit"},
            {"data":"teacher"},
            {"data":"class_time"},
            {"data":"class_place"}
        ],
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
        },
        bPaginate: true, //翻页按钮
        bInfo : true, //页脚信息
        bScrollCollapse : true, //插件高度自适应
        columnDefs:[{
            targets:10,
            data:"null",
            render:function (data,type,row) {
                var id = row.id;
                var year = row.school_year;
                var semester = row.semester;
                var html = "<a href='javascript:void(0);' onclick='getkcxx("+id+",\""+year+"\","+semester+")' class='table_a' >查看</a>";
                return html;
            }
        }]

    });





    // $.ajax({
    //     type:"POST",
    //     url:url,
    //     dataType: "json",
    //     success:function (data) {
    //         console.log(data);
    //         kcList = data.data;
    //         console.log(kcList);
    //         for(var i=0;i<kcList.length;i++){
    //             // var kc  = kcList[i];
    //             // var table = $("#kcxx_table").DataTable();
    //             // table.row.add({
    //             //     "课程名称":kc.name,
    //             //     "学院":kc.institute,
    //             //     "开课学年":kc.school_year,
    //             //     "学期":kc.semester,
    //             //     "分类":kc.category,
    //             //     "学分":kc.credit,
    //             //     "教师":kc.teacher,
    //             //     "上课时间":kc.class_time,
    //             //     "上课地点":kc.class_place
    //             // }).draw();
    //             var kc  = kcList[i];
    //             var rowItem =
    //                 '<tr>' +
    //                 '<td>' +kc.name +'</td>' +
    //                 '<td> '+kc.institute +' </td>' +
    //                 '<td> '+kc.school_year +' </td>' +
    //                 '<td> '+kc.semester +' </td>' +
    //                 '<td> '+kc.category +' </td>' +
    //                 '<td> '+kc.credit +' </td>' +
    //                 '<td> '+kc.teacher +' </td>' +
    //                 '<td> '+kc.class_time +' </td>' +
    //                 '<td> '+kc.class_place +' </td>' +
    //                 '</tr>';
    //             $("#kcxx_table tbody:last").append(rowItem);
    //         }
    //     },
    //     error:function (er) {
    //         alert("获取课程信息失败");
    //     }
    // });



}
function addTest() {
    var rowItem =
        '<tr>' +
        '<td> 测试1 </td>' +
        '<td> 测试2 </td>' +
        '<td> 测试3 </td>' +
        '<td> 测试4 </td>' +
        '<td> 测试5 </td>' +
        '<td> 测试6 </td>' +
        '<td> 测试7 </td>' +
        '<td> 测试8 </td>' +
        '<td> 测试9 </td>' +
        '<td> 测试10 </td>' +
        '<td> 测试11 </td>' +
        '<td> 测试12 </td>' +
        '<td> 测试13 </td>' +
        '<td> 测试14 </td>' +
        '<td> 测试15 </td>' +
        '<td> 测试16 </td>' +
        '<td> 测试17 </td>' +
        '</tr>';
    $("#content_table tbody:last").append(rowItem);
}
function delTest() {
    $("#content_table tr:last").remove();
}
function cjxx_show() {
    $("#jbxx").css("display","none");
    $("#xjxx").css("display","none");
    $("#kcxx").css("display","none");
    $("#cjxx").css("display","block");
    $("#grcjxx").css("display","none");
}
function grcjxx_show() {
    $("#jbxx").css("display","none");
    $("#xjxx").css("display","none");
    $("#kcxx").css("display","none");
    $("#cjxx").css("display","none");
    $("#grcjxx").css("display","block");
}
function getxjxx(i) {
    xjxx_show();
    var ele = "tr"+i;
    var tr = document.getElementById(ele);
    $("#sid").val(tr.cells[0].innerHTML);
    $("#sname").val(tr.cells[1].innerHTML);
    $("#sage").val(tr.cells[2].innerHTML);
    $("#ssex").val(tr.cells[3].innerHTML);
    $("#sinstitute").val(tr.cells[4].innerHTML);
    $("#smajor").val(tr.cells[5].innerHTML);
    $("#sclass").val(tr.cells[6].innerHTML);
    $("#sbirthday").val(tr.cells[7].innerHTML);
    $("#sstartTime").val(tr.cells[8].innerHTML);
    $("#sgrade").val(tr.cells[9].innerHTML);
    $("#scredit").val(tr.cells[10].innerHTML);
    $("#ssource").val(tr.cells[11].innerHTML);
    $("#snationality").val(tr.cells[12].innerHTML);
    $("#stype").val(tr.cells[13].innerHTML);
    $("#spoliticalStatus").val(tr.cells[14].innerHTML);
    $("#sgpa").val(tr.cells[15].innerHTML);
    $("#sstatus").val(tr.cells[16].innerHTML);

}


function getkcxx(id,year,semester) {
    cjxx_show();
    console.log(id+"   "+year+"   "+semester);
    $("#cid_up").val(id);
    $("#sy_up").val(year);
    $("#sm_up").val(semester);
    var url = basePath+"/get_one_course_score?CourseId="+id+"&SchoolYear="+year+"&Semester="+semester;
    // $.ajax({
    //     url:url,
    //     type:"POST",
    //     dataType: "JSON",
    //     success:function (data) {
    //         console.log(data);
    //     },
    //     error:function () {
    //         alert("获取单门课程信息失败");
    //     }
    // });

        $('#cjxx_table').DataTable({
            scrollX: true,
            bAutoWidth:true,
            bDestroy: true,
            ajax: url,
            columns:[
                {"data":"studentId"},
                {"data":"studentName"},
                {"data":"schoolYear"},
                {"data":"semester"},
                {"data":"major"},
                {"data":"studentClass"},
                {"data":"credit"},
                {"data":"score"},

            ],
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
            },
            bPaginate: true, //翻页按钮
            bInfo : true, //页脚信息
            bScrollCollapse : true, //插件高度自适应
            columnDefs:[{
                targets:8,
                data:"null",
                render:function (data,type,row) {
                    var id = row.studentId;
                    var html = "<a href='javascript:void(0);' onclick='updatecj("+id+")' class='table_a' >修改</a>";
                    return html;
                }
            }]
        });
        flag_cj = 1;


}

function search_cj() {
    var id = $("#sid").val();
    console.log(id);
    grcjxx_show();
    var url = basePath +"/get_score_by_student?studentId="+id;
    // $.ajax({
    //     url:url,
    //     type:"POST",
    //     dataType: "JSON",
    //     success:function (data) {
    //         console.log(data);
    //     },
    //     error:function () {
    //         alert("获取单门课程信息失败");
    //     }
    // });
    $('#grcjxx_table').DataTable({
        scrollX: true,
        bAutoWidth:true,
        bDestroy: true,
        ajax: url,
        columns:[
            {"data":"studentId"},
            {"data":"studentName"},
            {"data":"studentClass"},
            {"data":"courseId"},
            {"data":"courseName"},
            {"data":"category"},
            {"data":"teacher"},
            {"data":"schoolYear"},
            {"data":"semester"},
            {"data":"credit"},
            {"data":"score"},
        ],
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
        },
        bPaginate: true, //翻页按钮
        bInfo : true, //页脚信息
        bScrollCollapse : true, //插件高度自适应
        columnDefs:[{
            targets:11,
            data:"null",
            render:function (data,type,row) {
                var html = "<a href='javascript:void(0);' onclick='' class='table_a' >查看</a>";
                return html;
            }
        }]
    });
}

function updatecj(id) {
    $("#up_cj").dialog({
        title: '修改个人成绩',
        width: '450',
        height: '220',
        modal: true,
        autoOpen: false
    });
    $("#up_cj").dialog("open");
    $("#sid_up").val(id);
}