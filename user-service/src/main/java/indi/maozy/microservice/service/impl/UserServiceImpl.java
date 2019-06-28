package indi.maozy.microservice.service.impl;

import indi.maozy.microservice.dao.UserRepository;
import indi.maozy.microservice.entity.User;
import indi.maozy.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 用户服务类
 *
 * @author 毛中勇
 * @create 2019-06-27 19:04
 */
@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        String hash = ENCODER.encode(password);
        user.setPassword(hash);
        return userRepository.save(user);
    }


}