package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.RoleRepository;
import com.guigui.springboot.model.Position;
import com.guigui.springboot.model.Role;
import com.guigui.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public boolean addROle(Role role) {
        Role role1 = roleRepository.save(role);
        return roleRepository.existsById(role1.getId());
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
