package com.treasurehunt.user;

import com.treasurehunt.clients.fraud.FraudCheckResponse;
import com.treasurehunt.clients.fraud.FraudClient;
import com.treasurehunt.clients.notification.NotificationClient;
import com.treasurehunt.clients.notification.NotificationRequest;
import com.treasurehunt.clients.notification.NotificationResponse;
import com.treasurehunt.clients.user.UserRegistrationRequest;
import com.treasurehunt.amqp.RabbitMQMsgProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMsgProducer rabbitMQMsgProducer;
    public void registerUser(UserRegistrationRequest request){
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email valid
        //TODO: check if email not taken
        userRepository.saveAndFlush(user);
        // check if user is fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(user.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        // send notification

        //use rabbitmq
        NotificationRequest notificationRequest = new NotificationRequest(
                user.getId(),
                user.getEmail()
        );
        rabbitMQMsgProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

        //dont use rabbitmq
//        NotificationResponse notificationResponse = notificationClient.sendGreeting(
//                new NotificationRequest(
//                        user.getId(),
//                        user.getEmail()
//                )
//        );
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.getById(userId);
    }
}

