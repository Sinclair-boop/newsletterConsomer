package com.rmq.demo.service.impl;

import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.dtos.SendMailToUserDto;
import com.rmq.demo.mappers.MapperEmail;
import com.rmq.demo.models.Email;
import com.rmq.demo.repositories.MessageMenuRepository;
import com.rmq.demo.repositories.RepositoryEmail;
import com.rmq.demo.service.SendMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private final JavaMailSender javaMailSender;
    private final RepositoryEmail repositoryEmail;
    private final MapperEmail mapperEmail;
    private final MessageMenuRepository messageMenuRepository;

    @Override
    public void sendEmailsToUser(SendMailToUserDto dto){
        log.info("le message est de {}",dto.getBody()+dto.getBody());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getEmail());
        message.setSubject(dto.getSubject());
        message.setText(dto.getBody());
        javaMailSender.send(message);

    }
    @Override
    public void sendEmailsToUsers(MessageMenu messageMenu){
        List<Email> emails = repositoryEmail.findAll();
        List<String> recipients = emails.stream().map(mapperEmail::convertEmailToStringEmail).toList();
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(dto.getEmail());
        message.setTo(recipients.toArray(new String[0]));
        message.setSubject(messageMenu.getObjectFr());
        message.setText(messageMenu.getMessageFr());
        javaMailSender.send(message);

    }

    @Scheduled(fixedDelay = 10 * 60 * 60 * 1000) // 10 heures en millisecondes
    @Override
    public void sendEmailsToUsersWhitSheduled(){
        List<Email> emails = repositoryEmail.findAll();
        Iterable<MessageMenu> messageMenus = messageMenuRepository.findAll();
        MessageMenu messageMenu = messageMenus.iterator().next();
        List<String> recipients = emails.stream().map(mapperEmail::convertEmailToStringEmail).toList();
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(dto.getEmail());
        message.setTo(recipients.toArray(new String[0]));
        message.setSubject(messageMenu.getObjectFr());
        message.setText(messageMenu.getMessageFr());
        javaMailSender.send(message);

    }
}
