package com.seemee.dto;

import com.seemee.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    String status;
    String message;
    boolean authenticated;
    String userId;
    String role;
    User user;
    String token;
}
