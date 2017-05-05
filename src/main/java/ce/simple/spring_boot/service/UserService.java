package ce.simple.spring_boot.service;

import java.util.List;

import ce.simple.spring_boot.entity.user.User;

/**
 * 用户相关接口
 * @author zss
 * @date 2017年4月20日
 */
public interface UserService {
	
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	public User getById(String id);
	
	/**
	 * 通过名字获取用户
	 * @param name
	 * @return
	 */
	public List<User> getByName(String name);
}
