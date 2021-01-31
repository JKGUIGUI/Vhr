package com.guigui.springboot.dao;

import com.guigui.springboot.model.Sysmsg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SysmsgRepositoryTest {

    @Autowired
    SysmsgRepository sysmsgRepository;

    @Test
    void findById(){
        Sysmsg sysmag = sysmsgRepository.findById(60).get();
        System.out.println(sysmag);
    }
}