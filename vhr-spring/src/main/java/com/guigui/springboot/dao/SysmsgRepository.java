package com.guigui.springboot.dao;

import com.guigui.springboot.model.Sysmsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysmsgRepository extends JpaRepository<Sysmsg,Integer> {
}
