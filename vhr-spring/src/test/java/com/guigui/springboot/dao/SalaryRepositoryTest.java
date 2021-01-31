package com.guigui.springboot.dao;

import com.guigui.springboot.model.Salary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalaryRepositoryTest {

    @Autowired
    SalaryRepository salaryRepository;

    @Test
    void findById(){
        Salary salary = salaryRepository.findById(9).get();
        System.out.println(salary);
    }
}