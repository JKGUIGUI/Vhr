package com.guigui.springboot.dao;

import com.guigui.springboot.model.Employeeremove;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EmpolyeeremoveRepositoryTest {

    @Autowired
    EmpolyeeremoveRepository empolyeeremoveRepository;

    @Test
    void save(){
        Employeeremove employeeremove = new Employeeremove();
        employeeremove.setId(1);
        employeeremove.setEid(2);
        employeeremove.setAfterdepid(5);
        employeeremove.setAfterjobid(44);
        employeeremove.setRemovedate(new Date(System.currentTimeMillis()));
        employeeremove.setReason("撒的是");
        employeeremove.setRemark("俄方地方");
        empolyeeremoveRepository.save(employeeremove);
    }
}