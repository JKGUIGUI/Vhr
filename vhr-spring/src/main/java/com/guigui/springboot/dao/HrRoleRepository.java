package com.guigui.springboot.dao;

import com.guigui.springboot.model.hrRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface HrRoleRepository extends JpaRepository<hrRole,Integer> {
    public List<hrRole> findAllByHrid(Integer id);

    @Modifying
    @Transactional
    @Query("delete from hrRole where hrid=?1")
    public void deleteByHrid(Integer hrid);

    @Modifying
    @Transactional
    @Query(value = "insert into hr_role(hrid,rid) values(?1,?2)",nativeQuery = true)
    void addHrRole(Integer hrid,Integer rid);
}
