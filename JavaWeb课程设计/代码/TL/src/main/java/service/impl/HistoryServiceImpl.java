package service.impl;

import dao.IHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IHistoryService;
import vo.MsgHistory;
import vo.User;

import java.util.ArrayList;
import java.util.Date;

@Service
public class HistoryServiceImpl implements IHistoryService {

    @Autowired
    private IHistoryDAO iHistoryDAO;

    public void saveHistory(User user, String sendMsg, String returnMsg, String date) {
        iHistoryDAO.save_history(user.getUserName(),sendMsg,returnMsg,date);
    }

    public ArrayList<MsgHistory> getHistory(User user) {
        return iHistoryDAO.get_history(user.getUserName());
    }
}
