function sendMsg() {
    //获取用户输入的消息
    var msg = $("#msg-edit-text").val();

    //判断消息是否为空
    if (msg == "") {
        alert("发送消息不可为空！");
        return;
    }

    //消息长度超出一定限额
    var flag = 1;
    if (msg.length > 18) {
        //向上取证
        var flag = Math.ceil(msg.length / 18);
    }

    var msgHeight = 40 * flag;
    var msgDivHeight = 20 + msgHeight;

    //将消息转移至消息窗口
    var content =
        "<div class=\"user\"" + "style=\"height:" + msgDivHeight + "px\">" +
        "<img src=\"image/user.png\">" +
        "<div class=\"right_triangle\"></div>" +
        "<span style=\"height:" + msgHeight + "px\">" + msg + "</span>" +
        "</div>";

    $("#msg-window").append(content);


    //自动定位最下方
    $('#msg-window').scrollTop($('#msg-window')[0].scrollHeight);

    //将消息通过ajax发送至服务端并接受消息
    $.ajax({
        type: "post",
        url: "ask.do",
        data: "question=" + msg,
        dataType: "json",
        success: function(response) {
            if (response.code == 0) {
                var robotMsg = response.answer;
                //消息长度超出一定限额
                var robotFlag = 1;

                if (robotMsg.length > 18) {
                    //向上取证
                    var robotFlag = Math.ceil(robotMsg.length / 18);
                }

                var robotMsgHeight = 40 * robotFlag;
                var robotMsgDivHeight = 20 + robotMsgHeight;


                //将消息转移至消息窗口
                var robotContent =
                    "<div class=\"robot\"" + "style=\"height:" + robotMsgDivHeight + "px\">" +
                    "<img src=\"image/robot.png\">" +
                    "<div class=\"left_triangle\"></div>" +
                    "<span style=\"height:" + robotMsgHeight + "px\">" + robotMsg + "</span>" +
                    "</div>";

                $("#msg-window").append(robotContent);

                //自动定位最下方
                $('#msg-window').scrollTop($('#msg-window')[0].scrollHeight);
            }
        }
    });
    //清空用户消息编辑
    $("#msg-edit-text").val("");
}
$(document).ready(function() {


    $("#msg-send-btn").click(function(e) {
        sendMsg();
    });

    $("body").keydown(function(e) {
        if (event.keyCode == "13") {
            sendMsg();
        }
    });


    var app = new Vue({
        el: "#history-msg-display",
        data: {
            histories: []
        }
    });


    $("#history-msg").click(function(e) {
        $("#history-msg-background").addClass("show");
        $("#history-msg-window").addClass("show");

        $.ajax({
            type: "post",
            url: "getHistory.do",
            data: "",
            dataType: "json",
            success: function(response) {
                app.histories = response;
            }
        });
    });


    $("#close_image img").click(function(e) {
        $("#history-msg-background").removeClass("show");
        $("#history-msg-window").removeClass("show");
    });





});