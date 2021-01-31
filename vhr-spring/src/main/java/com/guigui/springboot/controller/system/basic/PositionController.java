package com.guigui.springboot.controller.system.basic;

import com.guigui.springboot.dao.PositionRepository;
import com.guigui.springboot.model.Position;
import com.guigui.springboot.model.RespBean;
import com.guigui.springboot.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionRepository positionRepository;
    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionRepository.findAll();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if (positionService.addPosition(position) == true) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updatePosition(position) == true){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id){
        if (positionService.deletePosition(id) == false){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deletePositionsByIds(@RequestBody List<Integer> ids){
        if (positionRepository.deletePosition(ids) == ids.size()) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
