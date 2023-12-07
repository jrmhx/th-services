package com.treasurehunt.user;

import com.treasurehunt.clients.fraud.FraudCheckResponse;
import com.treasurehunt.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FraudClient fraudClient;
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
        //send notification
    }
}

