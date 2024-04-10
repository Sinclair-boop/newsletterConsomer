package com.rmq.demo.service;

import com.rmq.demo.dtos.MessageMenu;

import java.util.List;
import java.util.Locale;

public interface MessageMenuService {
    MessageMenu getMessageMenu(String id);

    MessageMenu saveMessageMenu(MessageMenu messageMenu);

    Iterable<MessageMenu> saveManyMessageMenu(List<MessageMenu> messageMenus);

    void deleteMessage(String id);

    List<MessageMenu> getAllMessageMenu();

    String getMessage(String id, List args, Locale language);

    String getMessage(String id, List args, String language);
}
