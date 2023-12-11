package com.treasurehunt.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping(path = "api/v1/notification/greeting")
    NotificationResponse sendGreeting(@RequestBody NotificationRequest request);
}
