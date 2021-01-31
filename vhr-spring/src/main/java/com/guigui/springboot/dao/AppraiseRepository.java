package com.guigui.springboot.dao;

import com.guigui.springboot.model.Appraise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppraiseRepository extends JpaRepository<Appraise,Integer> {
}
