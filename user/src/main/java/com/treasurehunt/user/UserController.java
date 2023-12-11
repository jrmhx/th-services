package com.treasurehunt.user;

import com.treasurehunt.clients.user.UserDTO;
import com.treasurehunt.clients.user.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public record UserController(UserService userService) {

    @PostMapping("/create")
    public ResponseEntity<Void> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        log.info("new user registration {}", userRegistrationRequest);
        userService.registerUser(userRegistrationRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        log.info("Fetching user with id {}", id);
        UserDTO userResponse = UserDTOImpl.fromUser(userService.getUserById(id));
        if (userResponse == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userResponse);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info("Fetching all users");
        List<UserDTO> users = userService.getAllUsers()
                .stream()
                .map(UserDTOImpl::fromUser)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}