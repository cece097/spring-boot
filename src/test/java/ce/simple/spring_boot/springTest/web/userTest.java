package ce.simple.spring_boot.springTest.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ce.simple.spring_boot.entity.user.User;
import ce.simple.spring_boot.service.UserService;

public class userTest extends AbstractSpringMvcTester{
	
	@Autowired
	private UserService userService;

	@Test
	public void userTest(){
		User user = userService.getById("1");
		System.out.println(user);
	}	
}
