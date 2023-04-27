package com.springboot.notification.controller;

import com.springboot.notification.model.Notification;
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

    @PostMapping("/send-notification")
    public void sendMessage(@RequestBody final Notification notification) {

        service.notifyFrontend(notification.getMessageContent());
    }

    @PostMapping("/send-private-notification/{id}")
    public void sendPrivateMessage(@PathVariable final String id,
                                   @RequestBody final Notification notification) {
        service.notifyUser(id, notification.getMessageContent());
    }
}
