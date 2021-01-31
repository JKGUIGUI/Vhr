package com.guigui.springboot.dao;

import com.guigui.springboot.model.Hr;
import com.guigui.springboot.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HrRepositoryTest {
    @Autowired
    private HrRepository hrRepository;


    @Test
    void findAll(){
        List<Hr> list = hrRepository.findAll();
        for(Hr hr1:list){
            System.out.println(hr1);
        }
    }

    @Test
    void findByusername(){
       List<Role> roleList = hrRepository.findById(5).get().getRoles();
       List rid = new ArrayList();
       for (Role role:roleList){

           rid.add(role.getId());
       }
       System.out.println(rid);
    }

    @Test
    void findRolesById(){
        List<Role> list = hrRepository.findAllRolesById(13);
        System.out.println(list);
    }

    @Test
    void test01(){
        List<Hr> hrs = hrRepository.findByKeyName("李二");
        System.out.println(hrs);
    }
}