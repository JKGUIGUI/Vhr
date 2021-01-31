package com.guigui.springboot.dao;

import com.guigui.springboot.model.Nation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NationRepositoryTest {

    @Autowired
    NationRepository nationRepository;

    @Test
    void findById(){
        Nation nation = nationRepository.findById(3).get();
        System.out.println(nation);
    }
}