package ce.simple.spring_boot.bootTest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import ce.simple.spring_boot.entity.user.User;

@RunWith(SpringRunner.class)
@JsonTest
public class JacksonTest {
	
	@Autowired
	private JacksonTester<User> json;
	
	@Test
    public void testSerialize() throws Exception {
		User user = new User("赵山", "15652960936");
		String content = this.json.write(user).getJson();
		System.out.println("user json = "+content);
        // Assert against a `.json` file in the same package as the test
		Assertions.assertThat(this.json.write(user)).isEqualToJson("{\"id\":1,\"name\":\"赵山\",\"mobile\":\"15652960936\"}");
        // Or use JSON path based assertions
//		Assertions.assertThat(this.json.write(user)).hasJsonPathStringValue("@.make");
//		Assertions.assertThat(this.json.write(user)).extractingJsonPathStringValue("@.make")
//                .isEqualTo("赵山");
    }
	
	@Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\":1,\"name\":\"赵山\",\"mobile\":\"15652960936\"}";
        Assertions.assertThat(this.json.parseObject(content).getName()).isEqualTo("赵山");
        Assertions.assertThat(this.json.parse(content))
        			.isEqualTo(new User("赵山", "15652960936")); //报错，需要重写equal和hashcode方法
    }
	
	
}
