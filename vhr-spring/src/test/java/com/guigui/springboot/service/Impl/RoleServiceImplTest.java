package com.guigui.springboot.service.Impl;

import com.guigui.springboot.model.Role;
import com.guigui.springboot.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    RoleService roleService;

    @Test
    void Test(){
        Role role = new Role();
        role.setName("2222");
        role.setNamezh("ddddd");
        boolean i = roleService.addROle(role);
        System.out.println(i);
    }
}