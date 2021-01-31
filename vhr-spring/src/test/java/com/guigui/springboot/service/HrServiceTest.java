package com.guigui.springboot.service;

import com.guigui.springboot.model.Hr;
import com.guigui.springboot.model.Role;
import com.guigui.springboot.service.Impl.HrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@SpringBootTest
class HrServiceTest {
    @Autowired
    HrService hrService;

    @Test
    void UserNot(){
      UserDetails userDetails = new Hr();
      userDetails = hrService.loadUserByUsername("admin");
      System.out.println(userDetails);
    }

    @Test
    void test01(){
        List<Role> roles = hrService.getHrRolesByHrid(5);
        System.out.println(roles);
    }

    @Test
    void test02(){
        UserDetails userDetails = new Hr();
        userDetails = hrService.loadUserByUsername("libai");
        System.out.println(userDetails);
    }

    @Test
    void test03(){
        Hr hr = new Hr();
        hr.setName("朴智旻");
        hr.setUserface("dukop");
        boolean a = hrService.updateHr(hr);
        System.out.println(a);
    }
}