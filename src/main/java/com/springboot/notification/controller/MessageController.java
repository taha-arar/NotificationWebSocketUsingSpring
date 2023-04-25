package com.springboot.notification.controller;

import com.springboot.notification.dto.ResponseMessage;
import com.springboot.notification.model.Message;
import com.springboot.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final NotificationService notificationService;

    @MessageMapping("/notification")
    @SendTo("/app/notifications")
    public Message getMessage(final Message message) {
        notificationService.sendGlobalNotification();
        return new Message(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

    @MessageMapping("/private-notification")
    @SendToUser("/app/private-notifications")
    public Message getPrivateMessage(final Message message,
                                             final Principal principal) {
        notificationService.sendPrivateNotification(principal.getName());
        return new Message(HtmlUtils.htmlEscape(
                "Sending private message to user " + principal.getName() + ": "
                        + message.getMessageContent())
        );
    }
}
