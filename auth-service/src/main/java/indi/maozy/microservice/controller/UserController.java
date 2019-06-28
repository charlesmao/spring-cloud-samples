package indi.maozy.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 描述:
 * 用户控制器
 *
 * @author 毛中勇
 * @create 2019-06-27 17:17
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

}