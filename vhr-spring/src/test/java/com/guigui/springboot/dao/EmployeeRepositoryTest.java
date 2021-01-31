package com.guigui.springboot.dao;

import com.guigui.springboot.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findById() {
        Employee employee = employeeRepository.findById(1).get();
        System.out.println(employee);
    }

    @Test
    void test01(){
        Employee employee = employeeRepository.findById(1).get();
        System.out.println(employee);
    }

    @Test
    void test02(){
        Integer s = employeeRepository.findMaxWorkId();
        System.out.println(s);
    }

    @Test
    void test03(){
        employeeRepository.deleteById(1941);
    }

}