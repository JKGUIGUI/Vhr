package com.guigui.springboot.dao;

import com.guigui.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
   public List<Role> findAllById(Integer id);
   boolean existsById(Integer id);

   @Modifying  //一般在删除或者修改的时候用  用来标明是一个删除或者修改的标识
   @Transactional
   @Query("delete from  Role where id = :id")
   Integer deleteRole(@Param("id") Integer id);


}
