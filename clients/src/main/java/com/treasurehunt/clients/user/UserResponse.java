package com.treasurehunt.clients.user;

public record UserResponse(
    Integer id,
    String firstName,
    String lastName,
    String email
) {

}
