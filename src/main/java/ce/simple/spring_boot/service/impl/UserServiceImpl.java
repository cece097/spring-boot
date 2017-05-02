package ce.simple.spring_boot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ce.simple.spring_boot.entity.user.User;
import ce.simple.spring_boot.repository.UserRepository;
import ce.simple.spring_boot.service.UserService;

/**
 * 用户接口实现
 * @author zss
 * @date 2017年4月20日
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public User getById(String id) {
		logger.info("query user by id = {}",id);
		return userRepository.findOne(id);
	}

}
