package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconcls;
    private Boolean keepalive;
    private Boolean requireauth;
    private Integer parentid;
    private Boolean enabled;
 //   private List<Menu> children;
 //   private Meta meta;
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch=FetchType.EAGER)
    @JoinTable(name = "menu_role", joinColumns = {@JoinColumn(name ="mid" )}, inverseJoinColumns = { @JoinColumn(name = "rid") })
    private List<Role> roles;

}
