package com.treasurehunt.notification;

import com.treasurehunt.clients.notification.NotificationRequest;
import com.treasurehunt.clients.notification.NotificationResponse;
import com.treasurehunt.exceptions.NotificationSendingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(@Qualifier("javaMailSender") NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping(path = "/greeting")
    public NotificationResponse sendGreeting(@RequestBody NotificationRequest request){
        // simulate slow notification services
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.info("sending a slow greeting");
        }
        log.info("send greeting email to {}", request.sendToEmail());
        Boolean result = notificationService.sendGreeting(request);
        if (!result) {
            throw new NotificationSendingException("Failed to send greeting email.");
        }

        return new NotificationResponse(
                true,
                "Greeting sent successfully."
        );
    }
}
