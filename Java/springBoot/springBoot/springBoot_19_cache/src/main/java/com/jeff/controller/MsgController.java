package com.jeff.controller;

import com.jeff.controller.utils.R;
import com.jeff.domain.Book;
import com.jeff.service.BookService;
import com.jeff.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//模拟验证码验证过程
@RestController
@RequestMapping("/msg")
public class MsgController {
        
        @Autowired
        private MsgService msgService;

        //获取验证码
        @GetMapping("{tele}")
        public String get(@PathVariable String tele){
            return msgService.get(tele);
        }

        //验证验证码
        @PostMapping
        public boolean check(String tele, String code) throws IOException {
            return msgService.check(tele, code);
        }
}
