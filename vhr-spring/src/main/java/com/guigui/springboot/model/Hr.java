package com.guigui.springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.*;

@Getter
@Entity
@Table(name = "hr")
public class Hr implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String phone;
    private String telephone;
    private String address;
    private Boolean enabled;
    private String username;
    private String password;
    private String userface;
    private String remark;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch=FetchType.EAGER)
    @JoinTable(name = "hr_role", joinColumns = {@JoinColumn(name ="hrid" )}, inverseJoinColumns = { @JoinColumn(name = "rid") })
    private List<Role> roles ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hr hr = (Hr) o;
        return Objects.equals(username, hr.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    //返回分配给用户的角色列表
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.size());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    //账户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return  true;
    }

    //账户是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name == null?null:name.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public void setUserface(String userface) {
        this.userface = userface == null ? null : userface.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Hr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", enabled=" + enabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userface='" + userface + '\'' +
                ", remark='" + remark + '\'' +
                ", roles=" + roles +
                '}';
    }
}
