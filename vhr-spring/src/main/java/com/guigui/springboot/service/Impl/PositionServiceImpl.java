package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.PositionRepository;
import com.guigui.springboot.model.Position;
import com.guigui.springboot.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public boolean addPosition(Position position) {
        position.setEnabled(true);
        position.setCreatedate(new Date());
        Position position1 = positionRepository.save(position);
        return positionRepository.existsById(position1.getId());
    }

    @Override
    public boolean updatePosition(Position position) {
        String name = position.getName();
        position = positionRepository.findById(position.getId()).get();
        position.setName(name);
        positionRepository.save(position);
        return positionRepository.existsById(position.getId());
    }

    @Override
    public boolean deletePosition(Integer id) {
        positionRepository.deleteById(id);
        return positionRepository.existsById(id);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

}
