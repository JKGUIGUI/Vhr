package com.guigui.springboot.dao;

import com.guigui.springboot.model.Employeetrain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EmployeetrainRepositoryTest {

    @Autowired
    EmployeetrainRepository employeetrainRepository;

    @Test
    void save(){
        Employeetrain employeetrain = new Employeetrain();
        employeetrain.setId(1);
        employeetrain.setEid(2);
        employeetrain.setTraindate(new Date(System.currentTimeMillis()));
        employeetrain.setTraincontent("撒的是");
        employeetrain.setRemark("俄方地方");
        employeetrainRepository.save(employeetrain);
    }
}