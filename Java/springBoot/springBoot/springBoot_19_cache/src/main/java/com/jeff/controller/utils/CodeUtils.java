package com.jeff.controller.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {
    private String [] patch = {"000000","00000","0000","000","00","0",""}; //用于补0

    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666; //加密
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000; //保留后六位, result可能形如xxxxx000123, 得到code=123, 需要补0
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr; //补0
    }

    @Cacheable(value = "smsCode",key="#tele")
    public String get(String tele){
        return null; //如果缓存中有, 会直接返回冲缓存中读到的值; 如果缓存中没有, 会返回null
    }
}
