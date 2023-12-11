package com.treasurehunt.clients.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "user",
        path = "api/v1/user"
)
public interface UserClient {
    @PostMapping("/create")
    public ResponseEntity<Void> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest);

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id);

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers();
}
