/**
 * 统一ajax请求
 * 1、type:请求方法，2、data：请求数据，3、url：请求路径，4、callback：回调函数，5、是否异步
 */
function getAjax(type,data,url,callback,async){
    $.ajax({
        type: type,
        async:async,
        url:url,
        contentType: 'application/json',
        dataType: "json",
        data:JSON.stringify(data),
        success: function (res) {
            callback(res);
        },
        error: function () {
            alert("保存失败，请检查填写信息是否合法!!!");
        }
    });
}

/**
 * 提示框选择
 * @param message 提示框信息
 */
function alertShow(message){
    $('#alertModal .row').html(message);
    $('#alertModal').modal({
        backdrop:'static',
        keyboard:false,
        show:true
    })
}

/**
 * 自动关闭提示框
 */
function alertClose() {
    $('#alertModal').modal("hide");

}
/**
 * 统一button页面请求跳转
 * @param url
 */
function buttonPageJump(url) {
    App.scrollTop();
    var pageContentBody = $('.page-content-wrapper .page-content');
    App.startPageLoading();
    $.ajax({
        type: "GET",
        cache: false,
        url: url,
        dataType: "html",
        success: function (res) {
            App.stopPageLoading();
            pageContentBody.html(res);
            Layout.fixContentHeight(); // fix content height
            App.initAjax(); // initialize core stuff
        }
    });
}


	
	



