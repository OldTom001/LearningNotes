package com.jeff.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.jeff.controller.utils.CodeUtils;
import com.jeff.domain.SMSCode;
import com.jeff.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

//    @CreateCache(area = "smsRemote", name="code",expire = 10,timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE) //name自定义
    @CreateCache(area = "smsLocal", name="code",expire = 1000,timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL) //name自定义
//    @CreateCache(name="code",expire = 1000,timeUnit = TimeUnit.SECONDS, cacheType = CacheType.BOTH) //name自定义
    private Cache<String ,String> jetCache;

    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele,code);
        return code;
    }

    public boolean check(SMSCode smsCode) {
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }
}
