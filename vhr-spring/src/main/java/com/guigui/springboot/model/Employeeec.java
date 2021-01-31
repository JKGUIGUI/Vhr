package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Employeeec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer eid;
    private Date ecdate;
    private String ecreason;
    private Integer ecpoint;
    private Integer ectype;
    private String remark;
}
