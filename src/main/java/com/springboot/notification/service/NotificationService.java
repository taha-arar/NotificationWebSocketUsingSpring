package com.springboot.notification.service;

import com.springboot.notification.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final SimpMessagingTemplate messagingTemplate;


    public void sendGlobalNotification() {
        ResponseMessage message = new ResponseMessage("Global Notification");

        messagingTemplate.convertAndSend("/app/global-notifications", message);
    }

    public void sendPrivateNotification(final String userId) {
        ResponseMessage message = new ResponseMessage("Private Notification");

        messagingTemplate.convertAndSendToUser(userId,"/app/private-notifications", message);
    }
}
