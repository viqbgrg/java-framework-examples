package com.github.viqbgrg.shiro.boot.demo;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author hhj
 */
public class MyHostFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String ip = request.getRemoteAddr();
        System.out.println(ip);
        String[] ipArray = (String[]) mappedValue;

        if (ipArray == null || ipArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        return true;
    }

}
