package com.guigui.springboot.dao;

import com.guigui.springboot.model.Politicsstatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoliticsstatusRepositoryTest {

    @Autowired
    PoliticsstatusRepository politicsstatusRepository;

    @Test
    void findById(){
        Politicsstatus politicsstatus = politicsstatusRepository.findById(5).get();
        System.out.println(politicsstatus);
    }
}