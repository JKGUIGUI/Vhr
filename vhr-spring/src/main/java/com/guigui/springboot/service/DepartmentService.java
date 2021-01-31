package com.guigui.springboot.service;

import com.guigui.springboot.model.Department;

import java.util.List;

public interface DepartmentService {
   public List<Department> getAllDepartment();
   boolean addDep(Department dep);
   void deleteDepById(Department dep);
}
