package com.jeff.controller;

import com.jeff.domain.SMSCode;
import com.jeff.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tele){
        return smsCodeService.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        return smsCodeService.check(smsCode);
    }
}
