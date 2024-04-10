package com.rmq.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailAlreadyExistsException extends RuntimeException{
    private String message;
    public EmailAlreadyExistsException(){}
    public EmailAlreadyExistsException(String msg){
        super(msg);
        message = msg;
        log.error(msg);
    }
}
