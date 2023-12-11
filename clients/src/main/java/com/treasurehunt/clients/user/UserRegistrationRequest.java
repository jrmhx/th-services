package com.treasurehunt.clients.user;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String email
        ) {
}
