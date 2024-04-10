package com.rmq.demo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoSuchEmailExistsException extends RuntimeException{
    private String message;
    public NoSuchEmailExistsException(){}
    public NoSuchEmailExistsException(String msg){
        super(msg);
        message = msg;
        log.error(msg);
    }
}
