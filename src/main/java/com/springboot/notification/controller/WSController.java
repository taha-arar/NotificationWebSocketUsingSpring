/*
package com.springboot.notification.controller;

import com.springboot.notification.model.Message;
import com.springboot.notification.service.WSService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WSController {

    private final WSService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
        System.out.println("Global message in WSController");

        service.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable final String id,
                                   @RequestBody final Message message) {
        System.out.println("Private message in WSController");
        service.notifyUser(id, message.getMessageContent());
    }
}*/
