package com.treasurehunt.notification;

import com.treasurehunt.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("javaMailSender")
@AllArgsConstructor
public class JavaMailSenderNotificationService implements NotificationService{

    private final JavaMailSender mailSender;
    private final NotificationRecordRepository notificationRecordRepository;

    @Override
    public Boolean sendGreeting(NotificationRequest request) {
        NotificationSendState notificationSendState = NotificationSendState.SEND;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jez.hsing.dev@gmail.com");
        message.setTo(request.sendToEmail());
        message.setSubject("Greeting from Treasure Hunt!");
        message.setText("Welcome to Treasure Hunt!");
//        try {
//            mailSender.send(message);
//            notificationSendState = NotificationSendState.SEND;
//        } catch (MailException e){
//            notificationSendState = NotificationSendState.FAILED;
//        }

        notificationRecordRepository.saveAndFlush(
                NotificationRecord.builder()
                        .userId(request.userId())
                        .sendToEmail(request.sendToEmail())
                        .subject("Greeting from Treasure Hunt!")
                        .content("Welcome to Treasure Hunt!")
                        .sendState(notificationSendState)
                        .build()
        );
        return notificationSendState.equals(NotificationSendState.SEND);
    }
}
