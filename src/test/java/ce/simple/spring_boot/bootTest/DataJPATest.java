package ce.simple.spring_boot.bootTest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ce.simple.spring_boot.entity.user.User;
import ce.simple.spring_boot.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DataJPATest {
	
	@Autowired
    private UserRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
    public void testExample() throws Exception {
        this.entityManager.persist(new User("sboot", "15652960937"));
        User user = this.repository.findByName("sboot");
        System.out.println("user name: "+user.getName());
        System.out.println("user mobile: "+user.getMobile());
        Assertions.assertThat(user.getName()).isEqualTo("sboot");
        Assertions.assertThat(user.getMobile()).isEqualTo("15652960937");
    }
}
