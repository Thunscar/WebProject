package vo;

import java.util.Date;

public class MsgHistory {
    private String userName;
    private String send_msg;
    private String return_msg;
    private String msg_time;

    public MsgHistory(String userName, String send_msg, String return_msg, String msg_time) {
        this.userName = userName;
        this.send_msg = send_msg;
        this.return_msg = return_msg;
        this.msg_time = msg_time;
    }

    public String getMsg_time() {
        return msg_time;
    }

    public void setMsg_time(String msg_time) {
        this.msg_time = msg_time;
    }

    public MsgHistory() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSend_msg() {
        return send_msg;
    }

    public void setSend_msg(String send_msg) {
        this.send_msg = send_msg;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    @Override
    public String toString() {
        return "MsgHistory{" +
                "userName='" + userName + '\'' +
                ", send_msg='" + send_msg + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", msg_time=" + msg_time +
                '}';
    }
}
