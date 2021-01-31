package com.guigui.springboot.web.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    //Collection<ConfigAttribute> collection是是UrlFilterInvocationSecurityMetadataSource中的getAttributes方法传来的，
    // 表示当前请求需要的角色（可能有多个）

    /**
     *
     * @param authentication:包含了当前的用户信息，包括拥有的权限,
     *                      即之前UserDetailsService登录时候存储的用户对象
     * @param o:就是FilterInvocation对象，可以得到request等web资源
     *         configAttributes 是本次访问需要的权限。
     *         即上一步的 UrlFilterInvocationSecurityMetadataSource 中查询核对得到的权限列表
     * @param collection
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    //用户的角色在authentication里面，需要的角色在configAttributes里面，再区比较他们俩集合里面有没有包含关系就行
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //遍历需要的角色
        for (ConfigAttribute configAttribute : collection) {
            //它需要的角色
            String needRole = configAttribute.getAttribute();
            //如果它需要的角色是"ROLE_LOGIN"
            if ("ROLE_LOGIN".equals(needRole)) {
                //如果当前用户是匿名用户的实例的话，就是没登录
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登陆，请登陆");
                } else {
                    return;
                }
            }

            //获取当前登陆用户的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //如果这两个东西是相等的
                if (authority.getAuthority().equals(needRole))
                    return;
            }
        }

        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
