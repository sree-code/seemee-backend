package com.seemee.controller;

import com.seemee.dto.AuthenticateUser;
import com.seemee.dto.LoginResponse;
import com.seemee.model.User;
import com.seemee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getUserProfile(@PathVariable String email) {
        User user = userService.getUserProfile(email);
        return ResponseEntity.ok(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody AuthenticateUser authenticateUser) {
        LoginResponse response = userService.authenticateUser(authenticateUser);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/profile")
    public ResponseEntity<String> createUserProfile(@RequestBody User user) {
        userService.createUserProfile(user);
        return ResponseEntity.ok("User created successfully");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody AuthenticateUser authenticateUser) {
        String response = userService.updatePassword(authenticateUser);
        if(response.equalsIgnoreCase("success")){
            return ResponseEntity.ok("Password updated successfully");
        }else{
            return ResponseEntity.ok("Password update failed, Please try again after sometime");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/address/{index}")
    public ResponseEntity<String> updateAddress(@RequestBody User user, @PathVariable String index) {
        userService.updateAddress(user, index);
        return ResponseEntity.ok("Address updated successfully");
    }

}