package text;


import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * 测试UserDao类中的login方法
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123111");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
