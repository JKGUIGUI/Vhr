package com.guigui.springboot.dao;

import com.guigui.springboot.model.Appraise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AppraiseRepositoryTest {
    @Autowired
    AppraiseRepository appraiseRepository;

    @Test
    void save(){
        Appraise appraise = new Appraise();
        appraise.setId(1);
        appraise.setEid(2);
        appraise.setAppdate(new Date(System.currentTimeMillis()));
        appraise.setAppresult("升职业");
        appraise.setRemark("无");
        appraiseRepository.save(appraise);
    }
}