package com.treasurehunt.user;

import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {
    public void registerUser(UserRegistrationRequest request){
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email valid
        //TODO: check if email not taken
        userRepository.save(user);
    }
}

