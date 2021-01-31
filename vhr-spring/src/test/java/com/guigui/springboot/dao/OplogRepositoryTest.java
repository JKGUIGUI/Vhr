package com.guigui.springboot.dao;

import com.guigui.springboot.model.Oplog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class OplogRepositoryTest {

    @Autowired
    OplogRepository oplogRepository;

    @Test
    void save(){
        Oplog oplog = new Oplog();
        oplog.setId(1);
        oplog.setAdddate(new Date(System.currentTimeMillis()));
        oplog.setOperate("sdsd");
        oplog.setHrid(3);
        oplogRepository.save(oplog);
    }
}