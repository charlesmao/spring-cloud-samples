package indi.maozy.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 描述:
 * 配置Authentication Server
 *
 * @author 毛中勇
 * @create 2019-06-27 16:54
 */
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    // 将Token存储在内存中
    // private TokenStore tokenStore = new InMemoryTokenStore();
    private TokenStore tokenStore = new JdbcTokenStore(dataSource);

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //将客户端的信息存储在内存中
        clients.inMemory()
                //创建了一个client名为browser的客户端
                .withClient("browser")
                //配置验证类型
                .authorizedGrantTypes("refresh_token", "password")
                //配置客户端域为ui
                .scopes("ui")
                .and()
                .withClient("user-service")
                .secret("123456")
                .authorizedGrantTypes("client_credentials", "refresh_token", "password")
                .scopes("server");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置Token的存储方式
        endpoints.tokenStore(tokenStore)
                // 注入WebSecurityConfig配置的bean
                .authenticationManager(authenticationManager)
                // 读取用户的验证信息
                .userDetailsService(userDetailsService);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //对获取Token的请求不再拦截
        security.tokenKeyAccess("permitAll()")
                // 验证获取Token的验证信息
                .checkTokenAccess("isAuthenticated()");
    }
}