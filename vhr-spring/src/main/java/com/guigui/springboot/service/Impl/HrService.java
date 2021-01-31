package com.guigui.springboot.service.Impl;

import com.guigui.springboot.dao.HrRoleRepository;
import com.guigui.springboot.dao.RoleRepository;
import com.guigui.springboot.model.Hr;
import com.guigui.springboot.dao.HrRepository;
import com.guigui.springboot.model.Role;
import com.guigui.springboot.model.hrRole;
import com.guigui.springboot.service.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrRepository hrRepository;
    @Autowired
    HrRoleRepository hrRoleRepository;
    @Autowired
    RoleRepository roleRepository;

    //通过Hr的id查询Role
    public List<Role> getHrRolesByHrid(Integer hrid){
        List<hrRole> list = hrRoleRepository.findAllByHrid(hrid);
        List<Role> roles = new ArrayList<>();
        for (hrRole hrrole:list){
            roles.add(roleRepository.findById(hrrole.getRid()).get());
        }
        return roles;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrRepository.findByUsername(s);
        if (hr == null){
            throw new UsernameNotFoundException("用户名不对");
        }
        //给用户设置角色
        hr.setRoles(getHrRolesByHrid(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(){
        return hrRepository.findAllById(HrUtils.getCurrentHr().getId());
    }


    public Boolean updateHr(Hr hr){
        hr.setEnabled(true);
        if (hrRepository.findByName(hr.getName()) != null){
            Hr hr1 = hrRepository.findByName(hr.getName());
            if (hr.getPhone() != null){
                hr1.setPhone(hr.getPhone());
            }
            if (hr.getAddress() != null){
                hr1.setAddress(hr.getAddress());
            }
            if (hr.getTelephone() != null){
                hr1.setTelephone(hr.getTelephone());
            }
            if (hr.getUsername() != null){
                hr1.setUsername(hr.getUsername());
            }
            if (hr.getPassword() != null){
                hr1.setPassword(hr.getPassword());
            }
            if (hr.getUserface() != null){
                hr1.setUserface(hr.getUserface());
            }
            hrRepository.save(hr1);
            return hrRepository.existsById(hr1.getId());
        }else{
            hrRepository.save(hr);
            return hrRepository.existsById(hr.getId());
        }
    }

    public Boolean deleteHrById(Integer id){
        hrRepository.deleteById(id);
        return hrRepository.existsById(id);
    }
}
