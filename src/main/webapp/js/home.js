var strFullPath = window.document.location.href;
var strPath = window.document.location.pathname;
var pos = strFullPath.indexOf(strPath);
var prePath = strFullPath.substring(0, pos);
var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
var basePath = prePath;
basePath = prePath + postPath;

$(document).ready(function() {
    $("td").mousedown(function(e) {
        console.log(e.which);
        //右键为3
        if (3 == e.which) {
            alert("right click!");
        }
    })
},
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
})


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
//课程信息的显示
function kcxx_show() {
    $("#jbxx").css("display","none");
    $("#xjxx").css("display","none");
    $("#kcxx").css("display","block");
    $("#cjxx").css("display","none");

    var url = basePath+"/get_all_courses";

    $('#kcxx_table').DataTable({
        scrollX: true,
        //scrollY: "300px",
        bAutoWidth:true,
        serverSide:true,
        ajax: url,
        columns:[
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
        "bPaginate" : true, //翻页按钮
        "bInfo" : true, //页脚信息
        "bScrollCollapse" : true, //插件高度自适应

    });

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
}
function getxjxx(i) {
    xjxx_show();
    var ele = "tr"+i;
    var tr = document.getElementById(ele);
    console.log(tr.cells[0].innerHTML);
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


function getkcxx() {
    cjxx_show();

}