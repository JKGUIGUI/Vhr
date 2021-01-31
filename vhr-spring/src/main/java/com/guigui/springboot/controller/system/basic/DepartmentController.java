package com.guigui.springboot.controller.system.basic;

import com.guigui.springboot.dao.DepartmentRepository;
import com.guigui.springboot.model.Department;
import com.guigui.springboot.model.RespBean;
import com.guigui.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep){
        if (departmentService.addDep(dep) == true){
            return RespBean.ok("添加成功",dep);
        }
        return RespBean.error("添加失败");
    }

//    @DeleteMapping("/{id}")
}
