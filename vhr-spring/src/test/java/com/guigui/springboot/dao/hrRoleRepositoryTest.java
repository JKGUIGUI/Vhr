package com.guigui.springboot.dao;

import com.guigui.springboot.model.hrRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class hrRoleRepositoryTest {
    @Autowired
    HrRoleRepository hrRoleRepository;

    @Test
    void findById(){
        List<hrRole> list = hrRoleRepository.findAll();
        for(hrRole hrrole:list){
            System.out.println(hrrole);
        }
    }
}