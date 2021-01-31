package com.guigui.springboot.dao;

import com.guigui.springboot.model.Menu;
import com.guigui.springboot.model.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu,Integer> {
    public List<Menu> findAllById(Integer id);

    List<Menu> findAllByIdIn(List<Integer> id);

}
