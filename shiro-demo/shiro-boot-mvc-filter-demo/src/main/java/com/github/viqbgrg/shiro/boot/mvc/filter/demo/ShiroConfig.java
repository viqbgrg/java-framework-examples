package com.github.viqbgrg.shiro.boot.mvc.filter.demo;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.*;

/**
 * @author hhj
 */
@Configuration
public class ShiroConfig {

//    @Bean
//    public AuthorizationFilter shiroFirstFilter() {
//        return new MyShiroFilter();
//    }
    @Bean
    public Realm realm() {
        return new SimpleAccountRealm();
    }

    public static final String FILTER_NAME = "shiroFilter";

    /**
     * 禁止 session
     * @return
     */
    @Bean
    protected SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultWebSessionStorageEvaluator sessionStorageEvaluator = new DefaultWebSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return sessionStorageEvaluator;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        Map<String, Filter> filterMap = filterFactoryBean.getFilters();
        filterMap.put("myShiroFilter", new MyShiroFilter());
        filterMap.put("myShiroFilter1", new MyShiroFilter1());
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setFilters(filterMap);
        filterChainDefinitionMap.put("/**", "myShiroFilter");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        List<String> globalFilters = new ArrayList<>();
        globalFilters.add("myShiroFilter1");
        filterFactoryBean.setGlobalFilters(globalFilters);
        return filterFactoryBean;
    }





    @Bean
    protected FilterRegistrationBean filterShiroFilterRegistrationBean(ShiroFilterFactoryBean shiroFilterFactoryBean) throws Exception {
        FilterRegistrationBean<AbstractShiroFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        filterRegistrationBean.setFilter((AbstractShiroFilter) shiroFilterFactoryBean.getObject());
        filterRegistrationBean.setName(FILTER_NAME);
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
