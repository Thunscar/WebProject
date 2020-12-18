import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IHistoryService;
import service.IUserService;
import vo.User;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {
    private static Logger log =  LogManager.getLogger(Test.class.getName());

    @Autowired
    private IUserService userService;
    @Autowired
    private IHistoryService historyService;

    @Test
    public void test01(){
        System.out.println(log.getName());
        log.info("查询结果："+userService.getUserByUserName("ccc"));
    }

    @Test
    public void test02(){
        User user = new User("ccc","ccc");
//        userService.saveHistory(user,"asdasdasd","asdasdasdasd",new Date());
    }

    @Test
    public void test03(){
        User user = new User("ccc","ccc");
        historyService.saveHistory(user,"你是谁","我是小傻子",new Date().toString());
    }


    @Test
    public void test04(){

        User user = new User("ccc","ccc");
        System.out.println(historyService.getHistory(user));
    }

    @Test
    public void test05(){
        User user = new User("ccc","ccc","Ccc");
        boolean success = userService.register(user);
        System.out.println(success);
    }



}
