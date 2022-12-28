package com.jeff.service.impl;

import com.jeff.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String, String> codeCache = new HashMap<>();

    @Override
    public String get(String tele) {

        String code = tele.substring(tele.length()-6);
        codeCache.put(tele, code);
        return code;
    }

    @Override
    public boolean check(String tele, String code) {
        if(code!=null){
            return code.equals(codeCache.get(tele));
        }
        return false;
    }
}
