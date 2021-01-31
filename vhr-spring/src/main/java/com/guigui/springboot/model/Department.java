package com.guigui.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    private Integer parentid; //父节点

    private String deppath;
    private Boolean enabled;
    private Boolean isparent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentid", fetch = FetchType.EAGER)
    private List<Department> children;  //子节点

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "department",fetch = FetchType.EAGER)
    private List<Employee> employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
