package com.jeff.service;

import com.jeff.domain.SMSCode;

public interface SMSCodeService {
    public String sendCodeToSMS(String tele);
    public boolean check(SMSCode smsCode);
}
