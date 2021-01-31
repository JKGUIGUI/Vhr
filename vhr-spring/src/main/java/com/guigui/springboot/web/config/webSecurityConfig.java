package com.guigui.springboot.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guigui.springboot.model.Hr;
import com.guigui.springboot.model.RespBean;
import com.guigui.springboot.service.Impl.HrService;
import com.guigui.springboot.web.exception.AccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class webSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;
    @Autowired
    UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AccessDeniedHandler accessDeniedHandler;




    //明文显示密码
    @Bean
    public CustomPasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(hrService)
              .passwordEncoder(new CustomPasswordEncoder());

    //    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123")).roles("USER");

    }


    /**
     * 通过withObjectPostProcessor将MyFilterInvocationSecurityMetadataSource和MyAccessDecisionManager注入进来
     * 此url先被UrlFilterInvocationSecurityMetadataSource处理，然后 丢给UrlAccessDecisionManager处理
     * 如果不匹配，返回 MyAccessDeniedHandler
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //剩下的其他请求都是登陆之后就能访问的
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        return o;
                    }
                })
                //单表登陆
                .and().formLogin()
                //修改默认登陆的username
                .usernameParameter("username")
                //修改默认登陆的password
                .passwordParameter("password")
                //处理单表登陆的url路径
                .loginProcessingUrl("/doLogin")
                //默认看到的登录页面
                .loginPage("/login")
                //登陆成功的处理
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        //如果登陆成功就返回一段json
                        resp.setContentType("application/json;charset=utf-8");
                        //这是往出写的
                        PrintWriter out = resp.getWriter();
                        //登陆成功的hr对象
                        Hr hr = (Hr) authentication.getPrincipal();
                        RespBean ok = RespBean.ok("登陆成功",hr);
                        //把hr写成字符串
                        String s = new ObjectMapper().writeValueAsString(ok);
                        //把字符串写出去
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                //登陆失败的处理
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        //如果登陆失败就返回一段json
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        RespBean respBean = RespBean.error("登陆失败！");
                        if (e instanceof LockedException){
                            respBean.setMsg("账户被锁定，请联系管理员！");
                        }else if (e instanceof CredentialsExpiredException){
                            respBean.setMsg("密码过期，请联系管理员！");
                        }else if (e instanceof AccountExpiredException){
                            respBean.setMsg("账户过期，请联系管理员！");
                        }else if (e instanceof DisabledException){
                            respBean.setMsg("账户被禁用，请联系管理员！");
                        }else if (e instanceof  BadCredentialsException){
                            respBean.setMsg("用户名或者密码输入错误，请联系管理员！");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                })
                //跟登陆相关的接口就能直接访问
                .permitAll()
                .and()
                .logout()
                //注销成功后的回调
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功！")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                //关闭csrf攻击
                .csrf().disable();
    }
}
