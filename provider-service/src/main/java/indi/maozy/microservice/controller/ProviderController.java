package indi.maozy.microservice.controller;

import indi.maozy.microservice.common.intercepter.UserContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 * 提供者
 *
 * @author 毛中勇
 * @create 2019-10-17 16:12
 */
@RestController
public class ProviderController {

    @GetMapping("/provider/test")
    public String test(HttpServletRequest request) {
        System.out.println("auth success, the user is : " + UserContextHolder.currentUser().getUserName());
        System.out.println("----------------success access provider service----------------");
        return "success access provider service!";
    }

}