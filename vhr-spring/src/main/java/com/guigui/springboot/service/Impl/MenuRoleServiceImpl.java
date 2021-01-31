package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.MenuroleRepository;
import com.guigui.springboot.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    MenuroleRepository menuroleRepository;

    @Override
    public Integer updateMenuRole(Integer rid, List<Integer> mids) {
        menuroleRepository.deleteByRid(rid);
        int s = 0;
        for (int i = 0;i<mids.size();i++){
            menuroleRepository.addMenuRole(rid,mids.get(i));
            s = s + 1;
        }
        return s;
    }
}
