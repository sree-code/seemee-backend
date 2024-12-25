package com.seemee.dto;

import lombok.Data;

@Data
public class AuthenticateUser {

    String userId;
    String email;
    String password;
}
