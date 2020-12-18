package dao;

import org.apache.ibatis.annotations.Param;
import vo.MsgHistory;

import java.util.ArrayList;
import java.util.Date;

public interface IHistoryDAO {
    void save_history(@Param("userName") String userName,
                             @Param("send_msg") String send_msg,
                             @Param("return_msg") String return_msg,
                             @Param("msg_time") String msg_time);


    ArrayList<MsgHistory> get_history(@Param("userName") String userName);

}

