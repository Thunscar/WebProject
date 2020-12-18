package service.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dao.IUserDAO;
import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;
import vo.User;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;


    public User getUserByUserName(String userName) {
        return userDAO.get(userName);
    }

    public User checkLogin(User user) {
        User realUser = userDAO.get(user.getUserName());
        if(realUser != null && realUser.getPassword().equals(user.getPassword())){
            return realUser;
        }
        return null;
    }

    public boolean register(User user) {
        if(user != null){
            try{
                userDAO.add(user.getUserName(),user.getPassword(),user.getChrName());
            }catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }


}
