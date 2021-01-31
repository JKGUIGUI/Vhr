package com.guigui.springboot.controller.system.basic;

import com.alibaba.fastjson.JSON;
import com.guigui.springboot.dao.MenuRepository;
import com.guigui.springboot.dao.MenuroleRepository;
import com.guigui.springboot.dao.RoleRepository;
import com.guigui.springboot.model.Menu;
import com.guigui.springboot.model.RespBean;
import com.guigui.springboot.model.Role;
import com.guigui.springboot.service.MenuRoleService;
import com.guigui.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuroleRepository menuroleRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuRoleService menuRoleService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuRepository.findAll();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        return menuroleRepository.findMidByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(@RequestBody String str){
        Integer rid = Integer.parseInt(JSON.parseObject(str).get("rid").toString());
        List<Integer> mids = JSON.parseArray(JSON.parseObject(str).getString("mids"),Integer.class);
        if (menuRoleService.updateMenuRole(rid,mids) == mids.size()){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addROle(role) == true){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if(roleRepository.deleteRole(rid) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }



}
