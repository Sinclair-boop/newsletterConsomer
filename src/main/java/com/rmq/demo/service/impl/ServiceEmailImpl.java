package com.rmq.demo.service.impl;

import com.rmq.demo.dtos.EmailDto;
import com.rmq.demo.exception.EmailAlreadyExistsException;
import com.rmq.demo.exception.NoSuchEmailExistsException;
import com.rmq.demo.mappers.MapperEmail;
import com.rmq.demo.models.Email;
import com.rmq.demo.repositories.RepositoryEmail;
import com.rmq.demo.service.ServiceEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceEmailImpl implements ServiceEmail {
    private final RepositoryEmail repositoryEmail;
    private final MapperEmail mapperEmail;

    @Override
    public void createEmailService(EmailDto emailDto) throws EmailAlreadyExistsException {
        if (emailDto != null) {
            Email email = repositoryEmail.findEmailByEmail(emailDto.getEmail());
            if (email == null) {
                var emailToSave = mapperEmail.convertEmailDtoToEmail(emailDto);
                repositoryEmail.save(emailToSave);
            } else {
                throw new EmailAlreadyExistsException("L'adesse mail existe deja");

            }
        } else {
            log.error("l'objet Email est null");
        }

    }


    @Override
    public Iterable<Email> createEmailsService(List<EmailDto> dtos) {
        List<Email> emails = dtos.stream().map(mapperEmail::convertEmailDtoToEmail).toList();
        var emailsSaved = repositoryEmail.saveAll(emails);
        log.info("messages menu successful save+++++++");
        return emailsSaved;
    }

    @Override
    public Email findEmailService(String email) {
        var category = repositoryEmail.findEmailByEmail(email);
        if (category == null) {
            throw new NoSuchEmailExistsException("L'Email " + email + " n'existe pas");
        } else {
            return category;
        }
    }

    @Override
    public List<Email> getAllEmailsService() {

        var currentCategory = repositoryEmail.findAll();
        if (currentCategory == null) {
            throw new NoSuchEmailExistsException("La colection Email est null en base de donnée");
        } else if (currentCategory.isEmpty()) {
            throw new NoSuchEmailExistsException("La colection email est vide en base de donnée");
        } else {
            return currentCategory;

        }
    }

    @Override
    public Email updateEmailService(EmailDto dto) {
        Email emailToUpdate = repositoryEmail.findEmailByEmail(dto.getEmail());
        log.info("===>{}", emailToUpdate);
        if (emailToUpdate != null) {
            var emailUpdate = mapperEmail.convertEmailDtoToUpdateEmail(dto, emailToUpdate);
            return repositoryEmail.save(emailUpdate);
        } else {
            throw new NoSuchEmailExistsException("L'Email " + dto.getEmail() + " n'existe pas");
        }
    }

    @Override
    public void deleteEmailService(String email) {

        Email category = repositoryEmail.findEmailByEmail(email);
        if (category == null) {
            throw new EmailAlreadyExistsException("L'Email " + email + " n'existe pas.");
        } else {
            repositoryEmail.deleteEmailByEmail(email);
        }

    }
}
