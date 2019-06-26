package indi.maozy.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 描述:
 * 网关启动类
 *
 * @author 毛中勇
 * @create 2019-05-27 11:36
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayAppliction {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAppliction.class, args);
    }

}