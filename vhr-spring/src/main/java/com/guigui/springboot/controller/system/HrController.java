package com.guigui.springboot.controller.system;

import com.alibaba.fastjson.JSON;
import com.guigui.springboot.model.Hr;
import com.guigui.springboot.model.RespBean;
import com.guigui.springboot.model.Role;
import com.guigui.springboot.service.HrRoleService;
import com.guigui.springboot.service.Impl.HrService;
import com.guigui.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @Autowired
    HrRoleService hrRoleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(){
        return hrService.getAllHrs();
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrService.updateHr(hr) == true){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/roles")
    public RespBean updateHrRole(@RequestBody String str){
        Integer hrid = Integer.parseInt(JSON.parseObject(str).get("hrid").toString());
        List<Integer> rids = JSON.parseArray(JSON.parseObject(str).getString("rids"),Integer.class);
        if (hrRoleService.updateHrRole(hrid,rids) == rids.size()){
            return RespBean.ok("更新角色成功");
        }
        return RespBean.error("更新角色失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id)){
            return RespBean.ok("删除成功");
        }
        return  RespBean.error("删除失败");
    }

}
