package com.treasurehunt.notification;

import com.treasurehunt.clients.notification.NotificationResponse;
import com.treasurehunt.exceptions.NotificationSendingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotificationAdvice {

    @ExceptionHandler(NotificationSendingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public NotificationResponse handleSendingFailure(NotificationSendingException ex) {
        return new NotificationResponse(false, ex.getMessage());
    }
}
