import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IUserService;
import vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserControllerTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test1(){
        User user = userService.checkLogin(new User("ccc","ccc"));
        System.out.println(user);
    }
}
