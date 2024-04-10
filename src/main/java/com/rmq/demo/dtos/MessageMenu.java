package com.rmq.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class MessageMenu {

    @Id
    private String id;
    private String objectFr;

    public MessageMenu(String id, String objectFr, String objectEn, String messageFr, String messageEn) {
        this.id = id;
        this.objectFr = objectFr;
        this.objectEn = objectEn;
        this.messageFr = messageFr;
        this.messageEn = messageEn;
    }

    private String objectEn;
    private String messageFr;
    private String messageEn;

    public MessageMenu(String id, String messageFr, String messageEn) {
        this.id = id;
        this.messageFr = messageFr;
        this.messageEn = messageEn;
    }
}
