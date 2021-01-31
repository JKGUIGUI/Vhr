package com.guigui.springboot.dao;

import com.guigui.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    boolean existsById(Integer id);
    Employee findByName(String name);
    Employee findAllById(Integer id);

    @Query("SELECT max(i.workid) FROM Employee as i ")
    public Integer findMaxWorkId();

    @Modifying  //一般在删除或者修改的时候用  用来标明是一个删除或者修改的标识
    @Transactional
    @Query(name = "delete from  Employee where id = :id",nativeQuery = true)
    void deleteEmpById(@Param("id") Integer id);


}
