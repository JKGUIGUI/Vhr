package com.guigui.springboot.dao;

import com.guigui.springboot.model.Employeeec;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EmployeeecRepositoryTest {

    @Autowired
    EmployeeecRepository employeeecRepository;

    @Test
    void save(){
        Employeeec employeeec = new Employeeec();
        employeeec.setId(1);
        employeeec.setEid(2);
        employeeec.setEcdate(new Date(System.currentTimeMillis()));
        employeeec.setEcreason("生孩子");
        employeeec.setEcpoint(5);
        employeeec.setEctype(3);
        employeeec.setRemark("俄方地方");
        employeeecRepository.save(employeeec);
    }
}