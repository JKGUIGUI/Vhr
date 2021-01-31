package com.guigui.springboot.dao;

import com.guigui.springboot.model.Empsalary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmpsalaryRepositoryTest {

    @Autowired
    EmpsalaryRepository empsalaryRepository;

    @Test
    void findById(){
        Empsalary empsalary = empsalaryRepository.findById(6).get();
        System.out.println(empsalary);
    }
}