package com.springboot.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Message {
    private String messageContent;

    public Message(String messageContent) {
        this.messageContent = messageContent;
    }


    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
