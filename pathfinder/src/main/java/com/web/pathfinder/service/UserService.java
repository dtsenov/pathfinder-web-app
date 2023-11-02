package com.web.pathfinder.service;

import com.web.pathfinder.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    UserServiceModel findById(Long id);
}
