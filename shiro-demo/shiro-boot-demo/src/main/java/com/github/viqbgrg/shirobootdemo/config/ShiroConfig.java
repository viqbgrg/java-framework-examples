package com.github.viqbgrg.shirobootdemo.config;

import com.github.viqbgrg.shirobootdemo.service.IUserService;
import com.github.viqbgrg.shirobootdemo.shiro.UserRealm;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * shiro 的配置文件
 * @author hhj
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm userRealm(IUserService userService) {
        UserRealm myShiroRealm = new UserRealm(userService);
        return myShiroRealm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login/**", "anon");
        return chainDefinition;
    }

    /**
     * 关闭 session
     * @return
     */
    @Bean
    protected SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultWebSessionStorageEvaluator sessionStorageEvaluator = new DefaultWebSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return sessionStorageEvaluator;
    }
    @Bean
    protected FilterRegistrationBean filterShiroFilterRegistrationBean(ShiroFilterFactoryBean shiroFilterFactoryBean) throws Exception {

        FilterRegistrationBean<AbstractShiroFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        filterRegistrationBean.setFilter((AbstractShiroFilter) shiroFilterFactoryBean.getObject());
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }


    @Bean
    public Authenticator authenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
        return authenticator;
    }
}
