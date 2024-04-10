package com.rmq.demo.controller.impl;

import com.rmq.demo.config.MQConfig;
import com.rmq.demo.controller.SendMailController;
import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.dtos.SendMailToUserDto;
import com.rmq.demo.service.SendMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SendMailControllerImpl implements SendMailController {
    private final SendMailService sendMailService;
    @Override
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(SendMailToUserDto message) {
        System.out.println(message);
        sendMailService.sendEmailsToUser(message);
    }
    @Override
    @RabbitListener(queues = MQConfig.QUEUETWO)
    public void listenerSendMailToUsers(MessageMenu message) {
        System.out.println(message);
        sendMailService.sendEmailsToUsers(message);

    }
    @Override
    public void sendMailToUsersShedul(SendMailToUserDto message) {
        System.out.println(message);
        sendMailService.sendEmailsToUsersWhitSheduled();

    }

}