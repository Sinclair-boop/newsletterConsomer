package com.rmq.demo.controller;

import com.rmq.demo.dtos.EmailDto;
import com.rmq.demo.dtos.controllerResponse.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/apiv1/newsletter/handleEmail/")
public interface ControllerEmail {
    @PostMapping("create/email")
    ResponseEntity<ResponseDto> makeEmailController(@RequestBody EmailDto dto);
    @PostMapping("create/emails/many")
    ResponseEntity<ResponseDto> makeEmailsController(@RequestBody List<EmailDto> dtos);
    @GetMapping("getAll/emails")
    ResponseEntity<ResponseDto> getAllEmailsController();
    @GetMapping("get/email/{name}")

    ResponseEntity<ResponseDto> getEmailController(@PathVariable String name);
    @PutMapping("update/email")
    ResponseEntity<ResponseDto> updateEmailController(@RequestBody EmailDto categoryDto);
    @DeleteMapping("delete/email/{name}")
    ResponseEntity<ResponseDto> deleteEmailController(@PathVariable String name);
}
