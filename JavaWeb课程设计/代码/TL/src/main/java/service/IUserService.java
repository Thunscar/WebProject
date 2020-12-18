package service;

import vo.User;

import java.util.Date;

public interface IUserService {
    User getUserByUserName(String userName);

    User checkLogin(User user);

    boolean register(User user);

}
