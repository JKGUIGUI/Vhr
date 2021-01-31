package com.guigui.springboot.dao;

import com.guigui.springboot.model.Oplog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OplogRepository extends JpaRepository<Oplog,Integer> {
}
