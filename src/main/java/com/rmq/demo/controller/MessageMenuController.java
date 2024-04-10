package com.rmq.demo.controller;

import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.dtos.controllerResponse.MessageResponse.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/apiv1/newsletter/handleMenu")
public interface MessageMenuController {
    @GetMapping("/menus/{id}")
    ResponseEntity<ResponseDto> getMessageMenu(@PathVariable String id);

    @PostMapping("/menus")
    ResponseEntity<ResponseDto> saveMessageMenu(@RequestBody MessageMenu messageMenu);

    @PostMapping("/menus/many")
    ResponseEntity<ResponseDto> saveManyMessageMenu(@RequestBody List<MessageMenu> messageMenu);

    @GetMapping("/menus")
    ResponseEntity<ResponseDto> getAllMessageMenu();

    @DeleteMapping("/menus/{id}")
    ResponseEntity<ResponseDto> deleteMessageMenu(String id);
}
