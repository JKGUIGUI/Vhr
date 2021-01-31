package com.guigui.springboot.service;

import com.guigui.springboot.model.Position;

import java.util.List;

public interface PositionService {
    public boolean addPosition(Position position);
    public boolean updatePosition(Position position);
    public boolean deletePosition(Integer id);
    public List<Position> getAllPosition();


}
