package indi.maozy.microservice.repository;

import indi.maozy.microservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 * 用户
 *
 * @Author 毛中勇
 * @Date 2019-06-27 16:16
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
