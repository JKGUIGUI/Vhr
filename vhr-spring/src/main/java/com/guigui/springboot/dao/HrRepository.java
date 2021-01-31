package com.guigui.springboot.dao;

import com.guigui.springboot.model.Hr;
import com.guigui.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface HrRepository extends JpaRepository<Hr,Integer> {
    public Hr findByUsername(String username);
    public List<Role> findAllRolesById(Integer id);
    public Hr findByName(String name);
    boolean existsById(Integer id);
    List<Hr> findAllById(Integer id);

    @Override
    void deleteById(Integer integer);

    //模糊查找
    @Query(value="select * from Hr a where a.name like CONCAT('%',:keyName,'%') ",nativeQuery=true)
    List<Hr> findByKeyName(@Param("keyName") String keyName);

    @Modifying
    @Transactional
    @Query(value = "insert into menu_role(rid,mid) values(?1,?2)",nativeQuery = true)
    void addHr(Integer rid,Integer mids);

}
