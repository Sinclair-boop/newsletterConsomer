package com.rmq.demo.service;

import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.dtos.SendMailToUserDto;

public interface SendMailService {
    void sendEmailsToUser(SendMailToUserDto dto);
    void sendEmailsToUsers(MessageMenu messageMenu);
    void sendEmailsToUsersWhitSheduled();
}
