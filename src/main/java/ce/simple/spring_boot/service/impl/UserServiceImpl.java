package ce.simple.spring_boot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ce.simple.spring_boot.common.redis.SampleRedisUtil;
import ce.simple.spring_boot.config.constant.RedisKeyConstant;
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
	private SampleRedisUtil redisUtil;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public User getById(String id) {
		String key = String.format(RedisKeyConstant.USER_INFO, id);
		if(redisUtil.hasKey(key)){
			return redisUtil.getValuefromCache(key, User.class);
		}else{
			logger.info("query user by id = {}",id);
			User user = userRepository.findOne(id);
			redisUtil.setValueInCache(key, user);
			return user;
		}
	}

}
