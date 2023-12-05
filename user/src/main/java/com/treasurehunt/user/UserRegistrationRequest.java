package com.treasurehunt.user;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String email
        ) {
}
