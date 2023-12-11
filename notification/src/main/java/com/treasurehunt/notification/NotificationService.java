package com.treasurehunt.notification;

import com.treasurehunt.clients.notification.NotificationRequest;

public interface NotificationService {
    public Boolean sendGreeting(NotificationRequest notificationRequest);
}
