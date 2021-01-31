package com.guigui.springboot.dao;

import com.guigui.springboot.model.MailSendLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailsendlogRepository extends JpaRepository<MailSendLog,String> {
}
