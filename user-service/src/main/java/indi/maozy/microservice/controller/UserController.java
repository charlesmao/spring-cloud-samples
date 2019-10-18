package indi.maozy.microservice.controller;

import indi.maozy.microservice.domain.User;
import indi.maozy.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 用户操作控制器
 *
 * @author 毛中勇
 * @create 2019-06-27 19:08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public User createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.create(username, password);
    }


    @GetMapping("/test")
    public String getUsers() {
        return "Hello Spring Security";
    }



}