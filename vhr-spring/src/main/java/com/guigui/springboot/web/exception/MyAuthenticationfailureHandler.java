package com.guigui.springboot.web.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guigui.springboot.model.RespBean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证失败的处理
 */
public class MyAuthenticationfailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        RespBean respBean;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException){
            respBean = RespBean.error("账户名或者密码输入错误!");
        }else if (e instanceof LockedException){
            respBean = RespBean.error("账户被锁定，请联系管理员!");
        }else if (e instanceof CredentialsExpiredException){
            respBean = RespBean.error("密码过期，请联系管理员!");
        }else if (e instanceof AccountExpiredException){
            respBean = RespBean.error("账户过期，请联系管理员!");
        }else  if(e instanceof DisabledException){
            respBean = RespBean.error("账户被禁用，请联系管理员!");
        }else {
            respBean = RespBean.error("登陆失败");
        }
        httpServletResponse.setStatus(401);
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
