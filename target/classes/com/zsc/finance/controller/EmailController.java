package com.zsc.finance.controller;

import com.zsc.finance.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    SendEmailService emailService;

    @Autowired
    TemplateEngine templateEngine;

    @GetMapping("/sendSimpleEmail")
    @ResponseBody
    public String sendSimpleEmail(){
        String receiver="1005307373@qq.com";
        String subject="springboot 邮件发送测试";
        String content="一封来自于SpringBoot发送的qq的邮件，异步发送模式";
        emailService.sendEmail(receiver,subject,content);
        return "邮件发送成功，请检查邮箱！";
    }

    @GetMapping("/sendEmail")
    public String sendEmailByTemplate(@RequestParam("username") String username){
        String receiver="1005307373@qq.com";
        String subject="模板邮件的发送";
        Context context=new Context();
        context.setVariable("username","小怡");
        String code=RandomString.make(5);
        context.setVariable("code",code);
        String emailContent=templateEngine.process("emailTemplate",context);
        emailService.sendTemplateEmail(receiver,subject,emailContent);
        return "邮件发送成功，校验码为："+code;
    }

}
