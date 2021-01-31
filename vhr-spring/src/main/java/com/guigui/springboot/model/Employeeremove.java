package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Employeeremove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer eid;
    private Integer afterdepid;
    private Integer afterjobid;
    private Date removedate;
    private String reason;
    private String remark;
}
