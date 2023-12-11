package com.treasurehunt.clients.notification;

public record NotificationRequest(
        Integer userId,
        String sendToEmail
) {}
