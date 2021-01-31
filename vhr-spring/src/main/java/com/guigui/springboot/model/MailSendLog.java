package com.guigui.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class MailSendLog {
    @Id
    private String msgid;
    private Integer empid;
    //0 消息投递中   1 投递成功   2投递失败
    private Integer status;
    private String routekey;
    private String exchange;
    private Integer count;
    private Date trytime;
    private Date createtime;
    private Date updatetime;
}
