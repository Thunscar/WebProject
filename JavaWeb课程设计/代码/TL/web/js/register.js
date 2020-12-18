$(document).ready(function() {
    $("#login").click(function(e) {
        window.location.href = "index.html";
    });

    $("#register-btn").click(function(e) {
        $("#register-error-info").removeClass("error");

        var userName = $("#userName").val();
        var password = $("#password").val();
        var chrName = $("#chrName").val();
        var enterPassword = $("#enterPassword").val();

        if (password != enterPassword) {
            $("#register-error-info").text("两次输入密码不一致");
            $("#register-error-info").addClass("error");
            return;
        }

        $.ajax({
            type: "post",
            url: "register.do",
            data: "userName=" + userName + "&password=" + password + "&chrName=" + chrName,
            dataType: "json",
            success: function(response) {
                if (response.code == 0) {
                    $("#register-error-info").text(response.msg);
                    $("#register-error-info").addClass("error");
                } else {
                    $("#register-error-info").text(response.msg);
                    $("#register-error-info").addClass("error");
                }
            }
        });
    });
});