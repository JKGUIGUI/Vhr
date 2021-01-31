package com.guigui.springboot.dao;

import com.guigui.springboot.model.Joblevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface JoblevelRepository extends JpaRepository<Joblevel,Integer> {
    boolean existsById(Integer id);

    @Modifying  //一般在删除或者修改的时候用  用来标明是一个删除或者修改的标识
    @Transactional
    @Query("delete from Joblevel where id in (:id)")
    Integer deleteJoblevel(@Param("id") List<Integer> id);
}
