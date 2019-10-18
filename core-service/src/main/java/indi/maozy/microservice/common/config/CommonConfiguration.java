package indi.maozy.microservice.common.config;


import indi.maozy.microservice.common.intercepter.RestTemplateUserContextInterceptor;
import indi.maozy.microservice.common.intercepter.UserContextInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 描述:
 * 公共配置
 *
 * @author 毛中勇
 * @create 2019-10-17 15:53
 */
@Configuration
@EnableWebMvc
public class CommonConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 请求拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserContextInterceptor());
    }

    /***
     * RestTemplate 拦截器，在发送请求前设置鉴权的用户上下文信息
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateUserContextInterceptor());
        return restTemplate;
    }

}