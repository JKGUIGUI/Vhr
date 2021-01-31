package com.guigui.springboot.service;

import com.guigui.springboot.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenusByHrId(Integer id);
}
