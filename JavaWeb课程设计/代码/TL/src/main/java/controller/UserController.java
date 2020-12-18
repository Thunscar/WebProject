package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IUserService;
import vo.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(String userName, String password, HttpSession httpSession){
        Map<String,Object> map = new HashMap<String, Object>();
        User realUser = userService.checkLogin(new User(userName,password));
        if(realUser != null){
            map.put("code",0);
            map.put("msg","登陆成功");
            //将User存入Session
            httpSession.setAttribute("User",realUser);
        }else{
            map.put("code",-1);
            map.put("msg","账号或密码错误");
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(String userName,String password,String chrName){
        Map<String,Object> map = new HashMap<String, Object>();
        User newUser = new User(userName,password,chrName);
        boolean isSuccess = userService.register(newUser);
        if(isSuccess){
            map.put("code",0);
            map.put("msg","注册成功!");
        }else{
            map.put("code",-1);
            map.put("msg","账号已存在!");
        }
        return map;
    }
}
