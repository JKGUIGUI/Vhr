package com.guigui.springboot.dao;

import com.guigui.springboot.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoleRepositoryTest {
    @Autowired
    RoleRepository roleRepository;

    @Test
    void findById(){
        Role role = roleRepository.findById(2).get();
        System.out.println(role);
    }

    @Test
    void test01(){
        Integer i = roleRepository.deleteRole(22);
        System.out.println(i);
    }
}