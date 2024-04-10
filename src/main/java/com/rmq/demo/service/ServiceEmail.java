package com.rmq.demo.service;

import com.rmq.demo.dtos.EmailDto;
import com.rmq.demo.models.Email;

import java.util.List;

public interface ServiceEmail {
    void createEmailService(EmailDto dto);
    Iterable<Email> createEmailsService(List<EmailDto>  dtos);

    Email findEmailService(String id);
    List<Email> getAllEmailsService();
    Email updateEmailService(EmailDto dto);
    void deleteEmailService(String id);

}
