package com.rmq.demo.controller.impl;

import com.rmq.demo.controller.MessageMenuController;
import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.dtos.controllerResponse.MessageResponse.MainResponse;
import com.rmq.demo.dtos.controllerResponse.MessageResponse.ResponseDto;
import com.rmq.demo.service.MessageMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageMenuControllerImpl implements MessageMenuController {
    private final MessageMenuService messageMenuService;

    @Override
    public ResponseEntity<ResponseDto> getMessageMenu(String id) {
        log.info("===> request getting menu: {} ...", id);
        try{
            var messageMenu = messageMenuService.getMessageMenu(id);
            return MainResponse.response(messageMenu);
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDto> saveMessageMenu(MessageMenu messageMenu) {
        log.info("===>request saving menu {}...", messageMenu);
        try{
            var messageMenuSave = messageMenuService.saveMessageMenu(messageMenu);
            if (messageMenuSave != null){
                return MainResponse.responseOk(messageMenuSave);
            }
            return MainResponse.responseNotFound("message menu failed saving");
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDto> saveManyMessageMenu(List<MessageMenu> messageMenu) {

        log.info("===>request saving menu {}...", messageMenu);
        try{
            var messageMenuSave = messageMenuService.saveManyMessageMenu(messageMenu);
            if (messageMenuSave != null){
                return MainResponse.responseOk(messageMenuSave);
            }
            return MainResponse.responseNotFound("messages menu failed saving");
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDto> getAllMessageMenu() {
        log.info("===> request getting all menus...");
        try{
            var messageMenus = messageMenuService.getAllMessageMenu();
            if (messageMenus != null){
                return MainResponse.responseOk(messageMenus);
            }
            return MainResponse.responseNotFound("problem went getting all menus");
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteMessageMenu(String id) {
        log.info("===>request delete menu id: {}", id);
        try{
            messageMenuService.deleteMessage(id);
            return MainResponse.responseOk("successful delete menu id: "+id);
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }
}
