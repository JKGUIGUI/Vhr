package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.JoblevelRepository;
import com.guigui.springboot.model.Joblevel;
import com.guigui.springboot.model.Position;
import com.guigui.springboot.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelServiceImpl implements JobLevelService {
    @Autowired
    JoblevelRepository joblevelRepository;

    @Override
    public boolean addJobLevel(Joblevel joblevel) {
        joblevel.setEnabled(true);
        joblevel.setCreatedate(new Date());
        Joblevel joblevel1 = joblevelRepository.save(joblevel);
        return joblevelRepository.existsById(joblevel1.getId());
    }

    @Override
    public boolean updateJobLevel(Joblevel joblevel) {
        String name = joblevel.getName();
        joblevel = joblevelRepository.findById(joblevel.getId()).get();
        joblevel.setName(name);
        joblevelRepository.save(joblevel);
        return joblevelRepository.existsById(joblevel.getId());
    }

    @Override
    public boolean deleteJobLevel(Integer id) {
        joblevelRepository.deleteById(id);
        return joblevelRepository.existsById(id);
    }

    @Override
    public List<Joblevel> getAllJoblevels() {
        return joblevelRepository.findAll();
    }
}
