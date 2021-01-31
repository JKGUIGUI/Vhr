package com.guigui.springboot.service.Impl;

import com.guigui.springboot.model.Menu;
import com.guigui.springboot.service.MenuService;
import org.junit.jupiter.api.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuServiceImplTest {

    @Autowired
    private MenuService menuService;

    @Test
    void getMenusByHrId(){
        List<Menu> list = new ArrayList<>();
        list = menuService.getMenusByHrId(5);
        System.out.println(list);
    }
}