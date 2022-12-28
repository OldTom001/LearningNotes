package com.jeff.service.impl;

import com.jeff.controller.utils.CodeUtils;
import com.jeff.domain.SMSCode;
import com.jeff.service.SMSCodeService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

/*    @Autowired
    private MemcachedClient memcachedClient;*/

    @Override
//    @Cacheable(value = "smsCode", key = "#tele")
    @CachePut(value = "smsCode", key = "#tele")
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        return code;
    }

    @Override
    public boolean check(SMSCode smscode) {
        String code = smscode.getCode();
        String cacheCode = codeUtils.get(smscode.getTele());
        if(code!=null){
            return code.equals(cacheCode);
        }
        return false;
    }


/*    //------------------以下使用memcached------------------
    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele,10,code); //超时时间10s
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }
    @Override
    public boolean check(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }*/
}
