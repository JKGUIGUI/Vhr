package com.guigui.springboot.dao;

import com.guigui.springboot.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    public List<Department> findAllByParentid(int i);


}
