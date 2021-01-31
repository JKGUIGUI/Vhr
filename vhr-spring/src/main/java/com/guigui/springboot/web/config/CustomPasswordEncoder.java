package com.guigui.springboot.web.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 明文显示密码
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
