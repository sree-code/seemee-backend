package com.seemee.controller;

import com.seemee.model.User;
import com.seemee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendors")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getUserProfile(@PathVariable String email) {
        User user = userService.getUserProfile(email);
        return ResponseEntity.ok(user);
    }
}