package ce.simple.spring_boot.bootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import ce.simple.spring_boot.entity.user.User;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RandomPortExampleTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void helloTest() {
		String body = this.restTemplate.getForObject("/hello", String.class);
		assertThat(body).isEqualTo("Hello Word!!!");
	}
	
	@Test
	public void userTest() {
		User user = (User) this.restTemplate.getForObject("/user/1", User.class);
		
		assertThat(user).isEqualTo(new User(1L,"赵山","15652960936"));
	}
}
