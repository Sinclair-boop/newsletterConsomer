package com.rmq.demo.mappers;

import com.rmq.demo.dtos.EmailDto;
import com.rmq.demo.models.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MapperEmail {
    public Email convertEmailDtoToEmail(EmailDto dto){
        return Email.builder()
                .email(dto.getEmail())
                .date(LocalDateTime.now())
                .name(dto.getName())
                .id(UUID.randomUUID().toString()).build();
    }
    public Email convertEmailDtoToUpdateEmail(EmailDto dto, Email email){
        email.setEmail(dto.getEmail());
        email.setEmail(dto.getName());
        return email;
    }
    public String convertEmailToStringEmail(Email email){
        return email.getEmail();
    }
}
