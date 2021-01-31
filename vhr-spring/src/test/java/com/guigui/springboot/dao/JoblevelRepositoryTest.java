package com.guigui.springboot.dao;

import com.guigui.springboot.model.Joblevel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JoblevelRepositoryTest {

    @Autowired
    JoblevelRepository joblevelRepository;

    @Test
    void findById(){
        Joblevel joblevel = joblevelRepository.findById(9).get();
        System.out.println(joblevel);
    }
}