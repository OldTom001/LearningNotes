package com.jeff.service.impl.rabbitmq.topic;

import com.jeff.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列（rabbitmq topic），id："+id);
//        amqpTemplate.convertAndSend("topicExchange","topic.hhhhh.id",id); //匹配bindingTopic1
        amqpTemplate.convertAndSend("topicExchange","topic.orders.hhhh",id);//匹配bindingTopic2
    }

    @Override
    public String doMessage() {
        return null;
    }
}
