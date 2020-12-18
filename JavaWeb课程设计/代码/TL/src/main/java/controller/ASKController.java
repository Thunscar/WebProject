package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IHistoryService;
import service.ITLRobotService;
import service.IUserService;
import vo.MsgHistory;
import vo.TLResponse;
import vo.User;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ASKController {

    @Autowired
    private ITLRobotService itlRobotService;
    @Autowired
    private IHistoryService iHistoryService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/ask.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> askQuestion(String question, HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        String answer = null;
        try {
            answer = itlRobotService.askQuestion(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TLResponse tlResponse = new TLResponse(answer);
        String answerText = tlResponse.getText();

        if(answer != null){
            //将记录保存
            User user = (User) session.getAttribute("User");
            iHistoryService.saveHistory(user,question,answerText,new Date().toString());
            map.put("code",0);
            map.put("msg","请求成功");
            map.put("answer",answerText);
        }else{
            map.put("code",-1);
            map.put("msg","请求失败");
        }
        return map;
    }

    @RequestMapping(value = "/getHistory.do",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<MsgHistory> getHistory(HttpSession session){
        User user = (User) session.getAttribute("User");
        return iHistoryService.getHistory(user);
    }

}
