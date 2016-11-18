/**
 * Created by Jack on 2016/9/18.
 */

/* 初始化页面时查询医院选择列表 */
$(function () {
    $.ajax({
        "type": "GET",
        "url": "/queryUser",
        "dataType": "json",
        "success": function (data) {
            $("#example").empty();
            for (var i = 0; i < data.length; i++) {
                $("#example").append("<option value=" + data[i].userId + " style='width:auto'>" + data[i].userName + "</option>");
            }
        }
    });
    $("#example").select2({
        theme: "classic",
        placeholder: "请选择"
    });
});