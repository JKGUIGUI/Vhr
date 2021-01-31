package com.guigui.springboot.dao;

import com.guigui.springboot.model.Menu;
import com.guigui.springboot.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class MenuRepositoryTest {
    @Autowired
    MenuRepository menuRepository;

    @Test
    void findById(){
        Menu menu = menuRepository.findById(2).get();
        System.out.println(menu);
    }

    @Test
    void findAll(){
        List<Menu> allmenu = menuRepository.findAll();
        for(Menu menu:allmenu){
            List<Role> roles = menu.getRoles();
            int size = roles.size();
            System.out.println(size);
        }
    }
}