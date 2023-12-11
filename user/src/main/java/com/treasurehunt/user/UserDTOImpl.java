package com.treasurehunt.user;

import com.treasurehunt.clients.user.UserDTO;

class UserDTOImpl implements UserDTO {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;

    // Constructor is now private as the creation is managed by the static method
    private UserDTOImpl(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Static method to create a UserDTO from a User instance
    public static UserDTO fromUser(User user) {
        if (user == null){
            return null;
        } else {
            return new UserDTOImpl(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        }
    }

    // Implementations of interface methods
    @Override
    public Integer getId() { return id; }

    @Override
    public String getFirstName() { return firstName; }

    @Override
    public String getLastName() { return lastName; }

    @Override
    public String getEmail() { return email; }
}

