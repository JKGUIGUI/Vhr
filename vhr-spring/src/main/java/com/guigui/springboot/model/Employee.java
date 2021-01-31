package com.guigui.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Cacheable
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String idcard;
    private String wedlock;

    private Integer nationid;
    private String nativeplace;

    private Integer politicid;
    private String email;
    private String phone;
    private String address;

    private Integer departmentid;

    private Integer joblevelid;

    private Integer posid;
    private String engageform;
    private String tiptopdegree;
    private String specialty;
    private String school;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date begindate;
    private String workstate;
    private String workid;
    private Double contractterm;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date conversiontime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date notworkdate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date begincontract;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endcontract;
    private Integer workage;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "employee", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "departmentid") })
    private List<Department> department;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "employee", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "joblevelid") })
    private List<Joblevel> joblevels;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "employee", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "posid") })
    private List<Position> positions;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "employee", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "nationid") })
    private List<Nation> nations;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "employee", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "politicid") })
    private List<Politicsstatus> politicsstatuses;

}
