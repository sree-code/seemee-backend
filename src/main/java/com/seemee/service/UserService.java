package com.seemee.service;

import com.seemee.dto.AuthenticateUser;
import com.seemee.dto.LoginResponse;
import com.seemee.model.User;

public interface UserService {
    User getUserProfile(String email);
    void createUserProfile(User user);
    LoginResponse authenticateUser(AuthenticateUser authenticateUser);
    String updatePassword(AuthenticateUser authenticateUser);
    String updateAddress(User user, String type);
}
