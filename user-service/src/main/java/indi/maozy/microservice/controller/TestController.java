package indi.maozy.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 测试
 *
 * @author 毛中勇
 * @create 2019-09-18 14:09
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test api json";
    }

}