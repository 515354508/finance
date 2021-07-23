package com.zsc.finance.controller;

import com.zsc.finance.common.Msg;
import com.zsc.finance.entity.Admin;
import com.zsc.finance.entity.User;
import com.zsc.finance.service.AdminService;
import com.zsc.finance.service.SendEmailService;
import com.zsc.finance.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    SendEmailService emailService;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    RedisTemplate redisTemplate;
    //public static final Map<String, HttpSession> USR_SESSION = new HashMap<>();
    public static String last_login = "";

    @GetMapping("/loginVerifyUsername/{username}")
    @ResponseBody
    public Msg loginVerifyUsername(@PathVariable("username") String username) {
        User user = userService.selectUserByTerms(username, null);
        if (user != null) {
            return Msg.success();
        }
        Admin admin = adminService.selectAdminByTerms(username, null);
        if (admin != null) {
            return Msg.success();
        }
        return Msg.fail();
    }

    @GetMapping("/verifyLogin")
    @ResponseBody
    public Msg verifyLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                           HttpSession session) {

        User loginUser = userService.selectUserByTerms(username, password);
        if (loginUser != null) {
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户登录数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                return Msg.success().add("url", "/user/index.html");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                return Msg.fail();
            }
        }

        Admin admin = adminService.selectAdminByTerms(username, password);
        if (admin != null) {
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户登录数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                return Msg.success().add("url", "/admin/index.html");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                //model.addAttribute("msg","密码错误");
                return Msg.fail();
            }
        }
        return Msg.fail();
    }

    @PostMapping("/register")
    @ResponseBody
    public Msg register(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(0);
        user.setReputation("良好");
        userService.insertUser(user);
        return Msg.success().add("url", "/");
    }

    @PostMapping("/code")
    @ResponseBody
    public Object code(){
        Object o=redisTemplate.opsForValue().get("code");
        return o;
    }

    @PostMapping("/sendSimpleEmail")
    @ResponseBody
    public String sendSimpleEmail(){
        String receiver="1005307373@qq.com";
        String subject="springboot 邮件发送测试";
        String content="一封来自于SpringBoot发送的qq的邮件，异步发送模式";
        emailService.sendEmail(receiver,subject,content);
        return "邮件发送成功，请检查邮箱！";
    }

    @PostMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(@RequestParam("username") String username){
        String receiver="1005307373@qq.com";
        String subject="模板邮件的发送";
        Context context=new Context();
        context.setVariable("username",username);
        String code= RandomString.make(5);
        context.setVariable("code",code);
        redisTemplate.opsForValue().set("code",code);
        String emailContent=templateEngine.process("emailTemplate",context);
        emailService.sendTemplateEmail(receiver,subject,emailContent);
        return "邮件发送成功，校验码为："+code;
    }

    @RequestMapping("/forgot")
    public String forgot(HttpSession session, HttpServletRequest request,
                         ModelMap map) {
        return "templates/emailTemplate";
    }

}
