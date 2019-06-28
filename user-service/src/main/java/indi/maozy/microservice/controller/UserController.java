package indi.maozy.microservice.controller;

import indi.maozy.microservice.entity.User;
import indi.maozy.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:
 * 用户操作控制器
 *
 * @author 毛中勇
 * @create 2019-06-27 19:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public User createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.create(username, password);
    }

}