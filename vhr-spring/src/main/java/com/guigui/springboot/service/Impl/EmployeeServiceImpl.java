package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.EmployeeRepository;
import com.guigui.springboot.model.Employee;
import com.guigui.springboot.model.RespPageBean;
import com.guigui.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    SimpleDateFormat YearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public RespPageBean getEmployeeByPage(Integer page, Integer size) {
        if (page != null && size != null) {
            page= (page-1)*size;
        }
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.DESC,"id");
        Page<Employee> allPage = employeeRepository.findAll(pageable);
        List<Employee> data = allPage.getContent();
        long total = allPage.getTotalElements();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Override
    public boolean addEmp(Employee employee) {
        //自动计算合同期限
        Date begincontract = employee.getBegincontract();
        Date endcontract = employee.getEndcontract();
        double month =  (Double.parseDouble(YearFormat.format(endcontract))
                - Double.parseDouble(YearFormat.format(begincontract))) * 12
                - (Double.parseDouble(monthFormat.format(endcontract))
                - Double.parseDouble(monthFormat.format(begincontract)));
        employee.setContractterm(Double.parseDouble(decimalFormat.format(month/12)));
        Employee employee1 = employeeRepository.save(employee);
        return employeeRepository.existsById(employee1.getId());
    }

    @Override
    public Integer maxWorkID() {
        return employeeRepository.findMaxWorkId();
    }

    @Override
    @Transactional
    public boolean deleteEmpById(Integer id) {
        Employee employee = employeeRepository.findAllById(id);
        employee.setNationid(null);
        employee.setPoliticid(null);
        employee.setDepartmentid(null);
        employee.setJoblevelid(null);
        employee.setPosid(null);
        employeeRepository.flush();
        employeeRepository.save(employee);
        employeeRepository.flush();
        employeeRepository.deleteEmpById(id);
        return employeeRepository.existsById(id);
    }

    @Override
    public boolean updateEmp(Employee employee) {

                Employee employee1 = employeeRepository.findByName(employee.getName());
                if (employee.getGender() != null){
                    employee1.setPhone(employee.getPhone());
                }
                if (employee.getAddress() != null){
                    employee1.setAddress(employee.getAddress());
                }
                if (employee.getBirthday() != null){
                    employee1.setBirthday(employee.getBirthday());
                }
                if (employee.getIdcard() != null){
                    employee1.setIdcard(employee.getIdcard());
                }
                if (employee.getWedlock() != null){
                    employee1.setWedlock(employee.getWedlock());
                }
                if (employee.getNationid() != null){
                    employee1.setNationid(employee.getNationid());
                }
                if (employee.getNativeplace() != null){
                    employee1.setNativeplace(employee.getNativeplace());
                }
                if (employee.getPoliticid() != null){
                    employee1.setPoliticid(employee.getPoliticid());
                }
                if (employee.getEmail() != null){
                    employee1.setEmail(employee.getEmail());
                }
                if (employee.getPhone() != null){
                    employee1.setPhone(employee.getPhone());
                }
                if (employee.getDepartmentid() != null){
                    employee1.setDepartmentid(employee.getDepartmentid());
                }
                if (employee.getJoblevelid()!= null){
                    employee1.setJoblevelid(employee.getJoblevelid());
                }
                if (employee.getPosid()!= null){
                    employee1.setPosid(employee.getPosid());
                }
                if (employee.getEngageform()!= null){
                    employee1.setEngageform(employee.getEngageform());
                }
                if (employee.getTiptopdegree()!= null){
                    employee1.setTiptopdegree(employee.getTiptopdegree());
                }
                if (employee.getSpecialty()!= null){
                    employee1.setSpecialty(employee.getSpecialty());
                }
                if (employee.getSchool()!= null){
                    employee1.setSchool(employee.getSchool());
                }
                if (employee.getBegindate()!= null){
                    employee1.setBegindate(employee.getBegindate());
                }
                if (employee.getWorkstate()!= null){
                    employee1.setWorkstate(employee.getWorkstate());
                }
                if (employee.getWorkid()!= null){
                    employee1.setWorkid(employee.getWorkid());
                }
                if (employee.getConversiontime()!= null){
                    employee1.setConversiontime(employee.getConversiontime());
                }
                if (employee.getNotworkdate()!= null){
                    employee1.setNotworkdate(employee.getNotworkdate());
                }
                if (employee.getBegincontract()!= null){
                    employee1.setBegincontract(employee.getBegincontract());
                }
                if (employee.getEndcontract()!= null){
                    employee1.setEndcontract(employee.getEndcontract());
                }

                Date begincontract = employee1.getBegincontract();
                Date endcontract = employee1.getEndcontract();
                double month =  (Double.parseDouble(YearFormat.format(endcontract))
                        - Double.parseDouble(YearFormat.format(begincontract))) * 12
                        - (Double.parseDouble(monthFormat.format(endcontract))
                        - Double.parseDouble(monthFormat.format(begincontract)));
                employee1.setContractterm(Double.parseDouble(decimalFormat.format(month/12)));
                employeeRepository.save(employee1);
                return employeeRepository.existsById(employee1.getId());
        }


}

