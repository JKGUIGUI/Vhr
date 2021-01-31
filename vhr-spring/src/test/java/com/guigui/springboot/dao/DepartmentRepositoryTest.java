package com.guigui.springboot.dao;

import com.guigui.springboot.model.Department;
import com.guigui.springboot.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;


    @Test
    void findById(){
       Department department = departmentRepository.findById(1).get();
       System.out.println(department);
    }

    @Test
    void test01(){
        List<Department> list = departmentRepository.findAllByParentid(4);
        System.out.println(list);
    }

    @Test
    void test02(){
        departmentRepository.deleteById(104);
    }

}