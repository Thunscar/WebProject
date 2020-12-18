<%--
  Created by IntelliJ IDEA.
  User: Thunscar
  Date: 2020/12/13
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/main.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/vue.js"></script>
    <script src="js/main.js"></script>

    <title>图灵机器人交互窗口</title>
</head>

<body>
<div id="chat-window">
    <div id="msg-head">
        图灵机器人(当前用户:${User.chrName})
    </div>
    <div id="msg-window">
        <!--图灵机器人-->
        <div class="robot">
            <img src="image/robot.png">
            <div class="left_triangle"></div>
            <span>我是图灵机器人</span>
        </div>
        <!-- //用户
        <div class="user">
            <img src="image/qq.ico">
            <span>嗯嗯对</span>
        </div> -->



    </div>
    <!--分割线-->
    <div class="line"></div>
    <div id="msg-edit">
        <input type="text" id="msg-edit-text">
        <button id="msg-send-btn">发送</button>
        <button id="history-msg">历史</button>
    </div>

    <!-- 历史消息窗口 -->
    <div id="history-msg-background"></div>
    <div id="history-msg-window">
        <div id="close_image">
            <img src="image/close.png">
        </div>
        <div id="history-msg-display">
            <div v-for="history in histories">
                <small>{{history.msg_time}}</small>
                <p><strong>{{history.userName}}:&nbsp;</strong>{{history.send_msg}}</p>
                <p><strong>机器人:&nbsp;</strong>{{history.return_msg}}</p>
            </div>
        </div>
    </div>
</div>


</body>

</html>
