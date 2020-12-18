package service;

import vo.MsgHistory;
import vo.User;

import java.util.ArrayList;
import java.util.Date;

public interface IHistoryService {

    void saveHistory(User user, String sendMsg, String returnMsg, String date);

    ArrayList<MsgHistory> getHistory(User user);
}
