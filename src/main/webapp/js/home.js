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
function kcxx_show() {
    $("#jbxx").css("display","none");
    $("#xjxx").css("display","none");
    $("#kcxx").css("display","block");
    $("#cjxx").css("display","none");
    $('#kcxx_table').DataTable({
        scrollX: true,
        //scrollY: "300px",
        bAutoWidth:true,
    });
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