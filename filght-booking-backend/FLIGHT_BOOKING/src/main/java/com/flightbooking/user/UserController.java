package com.flightbooking.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.listAllUsers();
    }

    // Register a new user
    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User Registered Successfully!");
    }

    
}

