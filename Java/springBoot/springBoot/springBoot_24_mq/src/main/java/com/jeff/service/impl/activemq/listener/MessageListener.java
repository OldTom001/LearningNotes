package com.jeff.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

//@Component
public class MessageListener {

/*    *//*不转发*//*
    @JmsListener(destination = "order.queue.id")
    public void receive(String id){
        System.out.println("已完成短信发送业务，id："+id);
    }*/

    /*转发*/
    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id){
        System.out.println("已完成短信发送业务，id："+id);
        return "new:"+id;
    }

}
