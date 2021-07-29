package com.zsc.finance.service;



public interface SendEmailService {
    void sendTemplateEmail(String receiver,String subject,String content);
}
