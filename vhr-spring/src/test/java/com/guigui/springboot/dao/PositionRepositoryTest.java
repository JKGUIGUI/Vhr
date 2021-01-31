package com.guigui.springboot.dao;

import com.guigui.springboot.model.Position;
import com.guigui.springboot.service.PositionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PositionRepositoryTest {

    @Autowired
    PositionRepository positionRepository;
    @Autowired
    PositionService positionService;

    @Test
    void findById(){
        Position position = positionRepository.findById(29).get();
        System.out.println(position);
    }

    @Test
    void findAll(){
        List<Position> list = positionRepository.findAll();
        System.out.println(list);
    }

    @Test
    void test01(){
        Position position = new Position();
        position.setName("Java研发经理");
        boolean a = positionService.addPosition(position);
        System.out.println(a);
    }

    @Test
    void test02(){
        Position position = new Position();
        position.setName("Java研发经理666");
        position.setId(36);
        boolean b = positionService.updatePosition(position);
        System.out.println(b);
    }

    @Test
    void test03(){
        boolean c = positionService.deletePosition(39);
        System.out.println(c);
    }

    @Test
    void test04() {
        List<Integer> list = new ArrayList<>();
        list.add(37);
        list.add(38);
    }
}