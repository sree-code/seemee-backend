package com.seemee.repository;

import com.seemee.dto.AuthenticateUser;
import com.seemee.dto.LoginResponse;
import com.seemee.model.User;

public interface UserRepository {
    User getUserProfile(String email);
    void createUserProfile(User user);
    User authenticateUser(AuthenticateUser authenticateUser);
    String updatePassword(AuthenticateUser authenticateUser);
    String updateAddress(User user, String type);
}
