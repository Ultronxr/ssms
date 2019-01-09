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
}
