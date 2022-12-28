package com.jeff.service.impl;

import com.jeff.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender; //报错不用管

    //发送人
    private String from = "1021109865@qq.com";
    //接收人
    private String to = "1021109865@qq.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context1 = "测试邮件正文内容";
    //正文
    private String context2 = "<img src='ABC.JPG'/><a href='https://www.itcast.cn'>点开有惊喜</a>";



    @Override
    //发送简单邮件
    public void sendMail() {

/*        *//*-----------发送简单邮件-------------*//*
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(小甜甜)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context1);
        javaMailSender.send(message);*/


/*        *//*-----------发送含html内容的邮件-------------*//*
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(to+"(小甜甜)");
            helper.setTo(from);
            helper.setSubject(subject);
            helper.setText(context2,true);		//此处设置正文支持html解析

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /*-----------发送含附件的邮件-------------*/
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);		//此处设置支持附件
            helper.setFrom(to+"(小甜甜)");
            helper.setTo(from);
            helper.setSubject(subject);
            helper.setText(context1);

            //添加附件
            File f1 = new File("C:\\develop\\LearningNotes\\Java\\springBoot\\springBoot\\springBoot_23_maiil\\target\\springBoot_23_maiil-0.0.1-SNAPSHOT.jar");
            File f2 = new File("C:\\develop\\LearningNotes\\Java\\springBoot\\springBoot\\springBoot_23_maiil\\src\\main\\resources\\QQ图片20221103141934.png");

            helper.addAttachment(f1.getName(),f1);
            helper.addAttachment("最靠谱的培训结构.png",f2);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
