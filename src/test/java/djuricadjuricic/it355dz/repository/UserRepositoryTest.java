package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.User;
import djuricadjuricic.it355dz.service.DataLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest
{
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    DataLoader dataLoader;
    
    public UserRepositoryTest()
    {
    }

    
    @Test
    public void testFindByUsername()
    {
//        String expected = "djuro";
//        User user = userRepository.findByUsername(expected);
//        System.out.println(user.toString());
//        String result = user.getUsername();
//        assertEquals(expected, result);
        User expected = new User();
        expected.setUsername("djuro");
        entityManager.persist(expected);
        entityManager.flush();
        User result = this.userRepository.findByUsername("djuro");
        assertEquals(expected.getUsername(), result.getUsername());
    }

    
}
