package indi.maozy.microservice.common.intercepter;

import indi.maozy.microservice.common.vo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 描述:
 * RestTemplate拦截器
 *
 * @author 毛中勇
 * @create 2019-10-17 15:43
 */
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        User user = UserContextHolder.currentUser();
        HttpHeaders headers = httpRequest.getHeaders();
        headers.add("x-user-id", user.getUserId());
        headers.add("x-user-name", user.getUserName());
        headers.add("x-user-serviceName", httpRequest.getURI().getHost());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}