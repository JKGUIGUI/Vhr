package com.guigui.springboot.dao;

import com.guigui.springboot.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<Nation,Integer> {

}
