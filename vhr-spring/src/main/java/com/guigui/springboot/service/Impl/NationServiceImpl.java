package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.NationRepository;
import com.guigui.springboot.model.Nation;
import com.guigui.springboot.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    NationRepository nationRepository;


    @Override
    public List<Nation> getAllNation() {
        return nationRepository.findAll();
    }
}
