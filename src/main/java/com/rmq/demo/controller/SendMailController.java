package com.rmq.demo.controller;

import com.rmq.demo.config.MQConfig;
import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.dtos.SendMailToUserDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/apiv1/newsletter/handleSendMail")
public interface SendMailController {
    void listener(SendMailToUserDto message);
    public void listenerSendMailToUsers(MessageMenu message);
    @PostMapping("/sheduled")
    public void sendMailToUsersShedul(@RequestBody SendMailToUserDto message);
}
