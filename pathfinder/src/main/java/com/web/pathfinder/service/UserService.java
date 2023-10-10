package com.web.pathfinder.service;

import com.web.pathfinder.model.dto.UserLoginDTO;
import com.web.pathfinder.model.dto.UserRegisterDTO;

public interface UserService {

    void registerUser(UserRegisterDTO userRegisterBindingModel);

    boolean loginUser(UserLoginDTO userLoginDTO);
}
