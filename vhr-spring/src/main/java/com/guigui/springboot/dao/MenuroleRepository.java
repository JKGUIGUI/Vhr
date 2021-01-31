package com.guigui.springboot.dao;

import com.guigui.springboot.model.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MenuroleRepository extends JpaRepository<MenuRole,Integer> {
    public List<MenuRole> findAllById(Integer id);
    public List<MenuRole> findByRidIn(List<Integer> Rids);

    @Query("select menurole.mid from MenuRole menurole where menurole.rid = ?1")
    List<Integer> findMidByRid(Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into menu_role(rid,mid) values(?1,?2)",nativeQuery = true)
    void addMenuRole(Integer rid,Integer mids);

    @Modifying
    @Transactional
    @Query("delete from MenuRole where rid=?1")
    void deleteByRid(Integer rid);
}
