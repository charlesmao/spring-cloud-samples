package indi.maozy.microservice.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * 描述:
 * 配置OAuth2 Client
 *
 * @author 毛中勇
 * @create 2019-06-27 18:55
 */
//@Configuration
//@EnableOAuth2Client
//@EnableConfigurationProperties
public class OAuth2ClientConfig {


    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        // 配置受保护资源的信息
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        // 配置一个拦截器，对于每一个外来的请求，都会在request域内创建一个AccessTokenRequest类型的bean。
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(),
                clientCredentialsResourceDetails());
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        // 用于向认证服务器服务请求token
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

}