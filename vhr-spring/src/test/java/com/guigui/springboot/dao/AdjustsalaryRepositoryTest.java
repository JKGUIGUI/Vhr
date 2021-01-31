package com.guigui.springboot.dao;

import com.guigui.springboot.model.Adjustsalary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AdjustsalaryRepositoryTest {
    @Autowired
    private AdjustsalaryRepository adjustsalaryRepository;

    @Test
    void save(){
        Adjustsalary adjustsalary = new Adjustsalary();
        adjustsalary.setId(1);
        adjustsalary.setEid(2);
        adjustsalary.setAsdate(new Date(System.currentTimeMillis()));
        adjustsalary.setBeforesalary(10000);
        adjustsalary.setAftersalary(20000);
        adjustsalary.setReason("升职业");
        adjustsalary.setRemark("无");
        adjustsalaryRepository.save(adjustsalary);
    }
}