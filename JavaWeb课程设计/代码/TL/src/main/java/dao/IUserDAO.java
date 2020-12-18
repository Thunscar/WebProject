package dao;

import org.apache.ibatis.annotations.Param;
import vo.User;

import java.util.Date;

public interface IUserDAO {
    User get(@Param("userName") String userName);

    void add(@Param("userName") String userName,@Param("password") String password,@Param("chrName") String chrName);
}
