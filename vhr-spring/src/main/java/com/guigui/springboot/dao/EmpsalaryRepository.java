package com.guigui.springboot.dao;

import com.guigui.springboot.model.Empsalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpsalaryRepository extends JpaRepository<Empsalary,Integer> {
}
