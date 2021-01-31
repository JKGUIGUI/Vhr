package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.DepartmentRepository;
import com.guigui.springboot.model.Department;
import com.guigui.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAllByParentid(-1);
    }

    @Override
    public boolean addDep(Department dep) {
        dep.setEnabled(true);
        Department dep1 = departmentRepository.save(dep);
        return departmentRepository.existsById(dep1.getId());
    }

    @Override
    public void deleteDepById(Department dep) {
        departmentRepository.deleteById(dep.getId());
    }

}
