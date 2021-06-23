package com.github.viqbgrg.shirobootdemo.shiro;

import com.github.viqbgrg.shirobootdemo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author hhj
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    private IUserService userService;

    public UserRealm(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 授权信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 获取身份验证相关信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        return null;
    }
}
