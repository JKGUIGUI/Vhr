package com.guigui.springboot.controller.system.emp;

import com.guigui.springboot.model.*;
import com.guigui.springboot.service.*;
import com.guigui.springboot.service.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;

    //数据分页
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size){
        return employeeService.getEmployeeByPage(page,size);
    }

    //插入数据
    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if (employeeService.addEmp(employee) == true){
            return RespBean.ok("插入成功");
        }
        return RespBean.error("插入失败");
    }

    //删除数据
    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable("id") Integer id){
        if (employeeService.deleteEmpById(id) == false){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    //修改数据
    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        if (employeeService.updateEmp(employee) == true){
            return RespBean.ok("更新成功");
        }
        return  RespBean.error("更新失败");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNation(){
        return nationService.getAllNation();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/joblevels")
    public List<Joblevel> getAllJoblevels(){
        return jobLevelService.getAllJoblevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    //数据库中最大的工号+1
    @GetMapping("/maxWorkID")
    public RespBean getMaxWorkID(){
        return  RespBean.build().setStatus(200).setObj(String.format("%08d",employeeService.maxWorkID()+1));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list =
                (List<Employee>) employeeService.getEmployeeByPage(null,null).getData();
        return POIUtils.employee2Excel(list);
    }
}
