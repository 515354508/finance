package com.zsc.finance.service.impl;

import com.zsc.finance.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
@Service
public class SendEmailServiceImpl implements SendEmailService {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Value("1005307373@qq.com")
    private String sender;

    @Async
    public void sendTemplateEmail(String receiver,String subject,String content){
        MimeMessage message=mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            System.out.println("邮件发送成功！");
        }catch (Exception e){
            System.out.println("邮件发送失败");
            e.printStackTrace();
        }
    }
}
