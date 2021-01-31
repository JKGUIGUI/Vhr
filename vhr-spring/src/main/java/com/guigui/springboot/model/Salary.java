package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer basicsalary;
    private Integer bonus;
    private Integer lunchsalary;
    private Integer trafficsalary;
    private Integer allsalary;
    private Integer pensionbase;
    private Float pensionper;
    private Date createdate;
    private Integer medicalbase;
    private Float medicalper;
    private Integer accumulationfundbase;
    private Float accumulationfundper;
    private String name;
}
