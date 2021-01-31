package com.guigui.springboot.service;

import com.guigui.springboot.model.Employee;
import com.guigui.springboot.model.RespPageBean;

public interface EmployeeService {
    public RespPageBean getEmployeeByPage(Integer page, Integer size);

    public boolean addEmp(Employee employee);
    public Integer maxWorkID();
    public boolean deleteEmpById(Integer id);
    public boolean updateEmp(Employee employee);

}
