package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
//@Table(name = "adjustsalary")
public class Adjustsalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer eid;
    private Date asdate;
    private Integer beforesalary;
    private Integer aftersalary;
    private String reason;
    private String remark;
}
