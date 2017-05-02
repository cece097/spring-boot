package ce.simple.spring_boot.bootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ce.simple.spring_boot.entity.user.User;
import ce.simple.spring_boot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void userTest() {
		User user = this.userService.getById("1");
		
		assertThat(user).isEqualTo(new User("赵山","15652960936"));
	}
}
