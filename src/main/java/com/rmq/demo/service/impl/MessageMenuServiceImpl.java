package com.rmq.demo.service.impl;

import com.rmq.demo.dtos.MessageMenu;
import com.rmq.demo.repositories.MessageMenuRepository;
import com.rmq.demo.service.MessageMenuService;
import com.rmq.demo.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageMenuServiceImpl implements MessageMenuService {
    private final MessageMenuRepository messageMenuRepository;
    private final Utils utils;

    @Override
    public MessageMenu getMessageMenu(String id){
        var message =  messageMenuRepository.findById(id).orElse(new MessageMenu(id, "Pas de message disponible", "message not available"));
        log.info("----message menu get is : {}", message);
        return message;
    }

    @Override
    public MessageMenu saveMessageMenu(MessageMenu messageMenu){
        var message = messageMenuRepository.save(messageMenu);
        log.info("message menu successful save+++++++");
        return message;
    }

    @Override
    public Iterable<MessageMenu> saveManyMessageMenu(List<MessageMenu> messageMenus){
        var message = messageMenuRepository.saveAll(messageMenus);
        log.info("messages menu successful save+++++++");
        return message;
    }

    @Override
    public void deleteMessage(String id){
        messageMenuRepository.deleteById(id);
        log.info("message menu id {} successful delete+++++++", id);
    }

    @Override
    public List<MessageMenu> getAllMessageMenu(){
        var messages = messageMenuRepository.findAll();
        List<MessageMenu> result = StreamSupport.stream(messages.spliterator(), false)
                        .collect(Collectors.toList());
        log.info("datas: {}", result);
        return result;
    }

    @Override
    public String getMessage(String id, List args, Locale language){
        var message = getMessageMenu(id);
        log.info("===> \nargs: {}\nmessage: {}", args, message);
        if (message!=null){
            String theMessage = language == Locale.FRENCH? message.getMessageFr():message.getMessageEn();
            if (args!=null && !args.isEmpty()){
                for (int i = 0; i < args.size(); i++) {
                    theMessage = theMessage.replace("{"+i+"}", args.get(i).toString());
                }
            }
            return theMessage;
        }
        return null;
    }

    @Override
    public String getMessage(String id, List args, String language){
        return getMessage(id, args, utils.getLocaleByLanguage(language));
    }



}
