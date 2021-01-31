package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.PoliticsstatusRepository;
import com.guigui.springboot.model.Politicsstatus;
import com.guigui.springboot.service.PoliticsstatusService;
import com.guigui.springboot.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsstatusServiceImpl implements PoliticsstatusService {
    @Autowired
    PoliticsstatusRepository politicsstatusRepository;

    @Override
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusRepository.findAll();
    }
}
