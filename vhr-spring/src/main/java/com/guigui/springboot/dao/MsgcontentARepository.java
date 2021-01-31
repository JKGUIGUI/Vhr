package com.guigui.springboot.dao;

import com.guigui.springboot.model.Msgcontent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgcontentARepository extends JpaRepository<Msgcontent,Integer> {
}
