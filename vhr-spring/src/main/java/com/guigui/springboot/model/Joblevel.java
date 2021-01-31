package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class Joblevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String titlelevel;
    private Date createdate;
    private Boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joblevel joblevel = (Joblevel) o;
        return Objects.equals(name, joblevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
