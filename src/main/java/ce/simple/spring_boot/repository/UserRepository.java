package ce.simple.spring_boot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import ce.simple.spring_boot.entity.user.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	
	@Query("from User u where u.name = :name")
	public User findByName(@Param("name") String name);
}
