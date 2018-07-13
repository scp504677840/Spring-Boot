package com.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailApplicationTests {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void sendSimpleMailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("你好");
        message.setText("验证码为ABCDEF");
        message.setTo("abcdefg@163.com");
        message.setFrom("123456789@qq.com");
        mailSender.send(message);
    }

    @Test
    public void sendMimeMessage() {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("激活账户");
            helper.setText("激活码为<b style='color:red'>AYBFJA</b>", true);
            helper.setTo("abcdefg@163.com");
            helper.setFrom("123456789@qq.com");

            helper.addAttachment("logo.png",new File("/Users/scp/Documents/Workspace/Java/email/src/main/resources/static/logo.png"));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
