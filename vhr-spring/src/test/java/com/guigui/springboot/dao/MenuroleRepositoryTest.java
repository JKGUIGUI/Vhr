package com.guigui.springboot.dao;

import com.guigui.springboot.model.MenuRole;
import com.guigui.springboot.service.MenuRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MenuroleRepositoryTest {

    @Autowired
    MenuroleRepository menuroleRepository;
    @Autowired
    MenuRoleService menuRoleService;

    @Test
    void findById(){
        MenuRole menuRole = menuroleRepository.findById(161).get();
        System.out.println(menuRole);
    }

    @Test
    void test01(){
        List<Integer> list = menuroleRepository.findMidByRid(1);
        System.out.println(list);
    }

    @Test
    void test02(){ ;
         menuroleRepository.addMenuRole(14,9);

    }

    @Test
    void test03(){
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(8);
        Integer i = menuRoleService.updateMenuRole(14,list);
        System.out.println(i);
    }

    @Test
    void test04(){
        menuroleRepository.deleteByRid(14);
    }
}