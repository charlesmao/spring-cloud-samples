package indi.maozy.microservice.dao;

import indi.maozy.microservice.entity.User;
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
