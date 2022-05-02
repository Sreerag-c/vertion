package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.response.UserResponse;
import com.ayata.ayatamart.dto.response.UserRoleResponse;
import com.ayata.ayatamart.model.User;

public interface UserService {
    public UserResponse currentLoginStatus(User user);

    public UserRoleResponse isValidUser(String token);
}
