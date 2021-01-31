package com.guigui.springboot.dao;

import com.guigui.springboot.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {
}
