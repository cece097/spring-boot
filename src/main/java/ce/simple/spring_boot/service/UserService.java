package ce.simple.spring_boot.service;

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
}
