package com.guigui.springboot.service;

import com.guigui.springboot.model.Position;
import com.guigui.springboot.model.Role;

import java.util.List;

public interface RoleService {
    public boolean addROle(Role role);
    public List<Role> getAllRoles();
}
