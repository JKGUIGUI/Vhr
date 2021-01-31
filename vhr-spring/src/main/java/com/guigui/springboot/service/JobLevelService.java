package com.guigui.springboot.service;

import com.guigui.springboot.model.Joblevel;
import com.guigui.springboot.model.Position;

import java.util.List;

public interface JobLevelService {
    public boolean addJobLevel(Joblevel joblevel);
    public boolean updateJobLevel(Joblevel joblevel);
    public boolean deleteJobLevel(Integer id);
    public List<Joblevel> getAllJoblevels();
}
