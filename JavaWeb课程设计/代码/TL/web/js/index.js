$(document).ready(function() {

    //登录按钮点击事件
    $("#login-btn").click(function(e) {
        var userName = $("#userName").val();
        var password = $("#password").val();
        $.ajax({
            type: "post",
            url: "login.do",
            data: "userName=" + userName + "&password=" + password,
            dataType: "json",
            success: function(response) {
                if (response.code == 0) {
                    $("#error-info").attr("visibility", "hidden");
                    window.location.href = "main.jsp";
                } else {
                    $("#error-info").text(response.msg);
                    $("#error-info").css("visibility", "visible");
                }
            }
        });
    });


    //注册页面点击事件
    $("#register").click(function(e) {
        window.location.href = "register.html";
    });


});