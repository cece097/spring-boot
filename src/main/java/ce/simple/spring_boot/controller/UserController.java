package ce.simple.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ce.simple.spring_boot.entity.user.User;
import ce.simple.spring_boot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取用户个人信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable Long id){
		return userService.getById(id);
	}
}
