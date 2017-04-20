package ce.simple.spring_boot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ce.simple.spring_boot.entity.user.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
