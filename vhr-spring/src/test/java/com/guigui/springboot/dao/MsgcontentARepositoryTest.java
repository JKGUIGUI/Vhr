package com.guigui.springboot.dao;

import com.guigui.springboot.model.Msgcontent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsgcontentARepositoryTest {

    @Autowired
    MsgcontentARepository msgcontentARepository;

    @Test
    void findById(){
        Msgcontent msgcontent = msgcontentARepository.findById(14).get();
        System.out.println(msgcontent);
    }
}