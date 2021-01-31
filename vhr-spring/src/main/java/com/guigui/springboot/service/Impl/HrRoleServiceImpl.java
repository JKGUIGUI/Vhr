package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.HrRoleRepository;
import com.guigui.springboot.service.HrRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrRoleServiceImpl implements HrRoleService {
    @Autowired
    HrRoleRepository hrRoleRepository;

    @Override
    public Integer updateHrRole(Integer hrid, List<Integer> rids) {
        hrRoleRepository.deleteByHrid(hrid);
        int s = 0;
        for (int i = 0;i<rids.size();i++){
            hrRoleRepository.addHrRole(hrid,rids.get(i));
            s = s + 1;
        }
        return s;
    }
}
