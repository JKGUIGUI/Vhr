package com.guigui.springboot.web.config;

import com.guigui.springboot.dao.MenuRepository;
import com.guigui.springboot.model.Menu;
import com.guigui.springboot.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.Set;


//通过当前的请求地址，获取该地址需要的用户角色
//它的主要责任就是当访问一个url时，返回这个url所需要的访问权限

@Slf4j
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuRepository menuRepository;

    AntPathMatcher antPathMatcher = new AntPathMatcher();


    /**
     * 返回本次访问需要的权限，可以有多个权限
     * collection:当前请求需要的角色 o:实际上是一个filterInvocation对象
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //从filterInvocation里面可以获取当前请求的地址，
        // 拿到地址后，我就要拿这个地址去数据库里面跟这里的每一个菜单项去匹配，
        // 看是符合哪一个模式，然后再去看这个模式需要哪些角色
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //这个方法每次请求都会调用
        List<Menu> allMenu = menuRepository.findAll();
        //比较request跟这menus里面的url是否一致 遍历menus 借助AntPathMatcher工具进行
        for(Menu menu:allMenu){
            if (antPathMatcher.match(menu.getUrl(),requestUrl)
                    && menu.getRoles().size()>0){
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for(int i = 0;i<size;i++){
                    values[i] = roles.get(i).getName();
                }
                log.info("当前访问路径是{},这个url所需要的访问权限是{}",requestUrl,values);
                return SecurityConfig.createList(values);
            }
        }

        //没有匹配上的资源，都是登陆访问
        log.info("当前访问路径是{},这个url所需要的访问权限是{}","ROLE_LOGIN");
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    /**
     * 此处方法如果做了实现，返回了定义的权限资源列表，
     * Spring Security会在启动时校验每个ConfigAttribute是否配置正确，
     * 如果不需要校验，这里实现方法，方法体直接返回null即可。
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 方法返回类对象是否支持校验，
     * web项目一般使用FilterInvocation来判断，或者直接返回true
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
