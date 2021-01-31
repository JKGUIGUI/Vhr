package com.guigui.springboot.dao;

import com.guigui.springboot.model.MailSendLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MailsendlogRepositoryTest {
    @Autowired
    MailsendlogRepository mailsendlogRepository;

    @Test
    void save(){
        MailSendLog mailSendLog = new MailSendLog();
        mailSendLog.setMsgid("10086");
        mailSendLog.setEmpid(01);
        mailSendLog.setStatus(1);
        mailSendLog.setRoutekey("www");
        mailSendLog.setExchange("jjj");
        mailSendLog.setCount(22);
        mailSendLog.setTrytime(new Date(System.currentTimeMillis()));
        mailSendLog.setCreatetime(new Date(System.currentTimeMillis()));
        mailSendLog.setUpdatetime(new Date(System.currentTimeMillis()));
        mailsendlogRepository.save(mailSendLog);
    }
}