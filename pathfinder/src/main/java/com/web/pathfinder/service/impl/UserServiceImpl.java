package com.web.pathfinder.service.impl;

import com.web.pathfinder.model.binding.UserRegisterBindingModel;
import com.web.pathfinder.model.entity.UserEntity;
import com.web.pathfinder.model.enums.LevelEnum;
import com.web.pathfinder.repository.UserRepository;
import com.web.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        userRepository.save(map(userRegisterBindingModel));
    }

    private UserEntity map(UserRegisterBindingModel userRegisterBindingModel) {
        UserEntity user = new UserEntity();

        user.setUsername(userRegisterBindingModel.getUsername());
        user.setFullName(userRegisterBindingModel.getFullName());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setLevel(LevelEnum.BEGINNER);
        user.setPassword(userRegisterBindingModel.getPassword());
        return user;
    }
}
