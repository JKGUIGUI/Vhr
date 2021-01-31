package com.guigui.springboot.controller.system.basic;

import com.guigui.springboot.dao.JoblevelRepository;
import com.guigui.springboot.dao.PositionRepository;
import com.guigui.springboot.model.Joblevel;
import com.guigui.springboot.model.Position;
import com.guigui.springboot.model.RespBean;
import com.guigui.springboot.service.JobLevelService;
import com.guigui.springboot.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {

    @Autowired
    JoblevelRepository joblevelRepository;
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return joblevelRepository.findAll();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        if (jobLevelService.addJobLevel(joblevel) == true) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
        if (jobLevelService.updateJobLevel(joblevel) == true){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id){
        if (jobLevelService.deleteJobLevel(id) == false){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(@RequestBody List<Integer> ids){
        if (joblevelRepository.deleteJoblevel(ids) == ids.size()) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}

