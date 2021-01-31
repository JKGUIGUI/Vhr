package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.HrRoleRepository;
import com.guigui.springboot.dao.MenuRepository;
import com.guigui.springboot.dao.MenuroleRepository;
import com.guigui.springboot.model.Menu;
import com.guigui.springboot.model.MenuRole;
import com.guigui.springboot.model.hrRole;
import com.guigui.springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuroleRepository menuroleRepository;
    @Autowired
    private HrRoleRepository hrRoleRepository;

    @Override
    public List<Menu> getMenusByHrId(Integer hrid) {
        List<hrRole> list = hrRoleRepository.findAllByHrid(hrid);
        List<Integer> rids = new ArrayList<>();
        for (hrRole hrrole:list){
            rids.add(hrrole.getRid());
        }
        List<MenuRole> mids = menuroleRepository.findByRidIn(rids);
        List<Integer> menus = new ArrayList<>();
        for (MenuRole menuRole:mids){
           menus.add(menuRole.getMid());
        }
        return menuRepository.findAllByIdIn(menus);
    }
}
