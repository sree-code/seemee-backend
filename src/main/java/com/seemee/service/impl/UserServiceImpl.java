package com.seemee.service.impl;

import com.seemee.constants.SeeMeeConstants;
import com.seemee.dto.AuthenticateUser;
import com.seemee.dto.LoginResponse;
import com.seemee.model.User;
import com.seemee.repository.UserRepository;
import com.seemee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserRepository userRepository;


    @Override
    public User getUserProfile(String email) {
        return userRepository.getUserProfile(email);
    }

    @Override
    public void createUserProfile(User user) {
        userRepository.createUserProfile(user);
    }

    @Override
    public LoginResponse authenticateUser(AuthenticateUser authenticateUser) {
        User user = userRepository.authenticateUser(authenticateUser);
        LoginResponse loginResponse = new LoginResponse();
        if (BCrypt.checkpw(authenticateUser.getPassword(), user.getPassword())) {
            loginResponse.setStatus(SeeMeeConstants.SUCCESS);
            loginResponse.setUser(user);
            loginResponse.setAuthenticated(true);
            loginResponse.setUserId(user.getUserId());
            loginResponse.setRole(String.join(",", user.getRole()));
            loginResponse.setToken(user.getUserId()+user.getEmail().length());
        } else {
            loginResponse.setAuthenticated(false);
            loginResponse.setStatus(SeeMeeConstants.FAILED);
        }
        return loginResponse;
    }

    @Override
    public String updatePassword(AuthenticateUser authenticateUser) {
        return userRepository.updatePassword(authenticateUser);
    }

    @Override
    public String updateAddress(User user, String index) {
        return userRepository.updateAddress(user, index);
    }


}
