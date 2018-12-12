import dao.UserDAO;
import impl.UserDaoImpl;
import model.User;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import org.junit.Test;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserDaoImplTest {
        @Resource
        UserDAO userDao;
        @Test
        public void test() {
            User user = userDao.getUserById(1);
            System.out.print(user.toString());
        }



}
