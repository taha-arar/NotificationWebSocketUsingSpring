package com.springboot.notification.controller;

import com.springboot.notification.model.Notification;
import com.springboot.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
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
    public Notification getMessage(final Notification notification) {
        notificationService.sendGlobalNotification();
        return new Notification(HtmlUtils.htmlEscape(notification.getMessageContent()));
    }

    @MessageMapping("/private-notification")
    @SendToUser("/app/private-notifications")
    public Notification getPrivateMessage(final Notification notification,
                                          final Principal principal) {
        notificationService.sendPrivateNotification(principal.getName());
        return new Notification(HtmlUtils.htmlEscape(
                "Sending private notification to user " + principal.getName() + ": "
                        + notification.getMessageContent())
        );
    }
}
