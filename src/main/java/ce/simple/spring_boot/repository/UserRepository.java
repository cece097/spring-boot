package ce.simple.spring_boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ce.simple.spring_boot.entity.user.User;
import ce.simple.spring_boot.common.data.ExpandRepository;

public interface UserRepository extends ExpandRepository<User, String> {
	
	@Query("from User u where u.name = :name")
	public User findByName(@Param("name") String name);
}
