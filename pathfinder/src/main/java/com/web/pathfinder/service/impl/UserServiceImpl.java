package com.web.pathfinder.service.impl;

import com.web.pathfinder.model.dto.UserLoginDTO;
import com.web.pathfinder.model.dto.UserRegisterDTO;
import com.web.pathfinder.model.entity.UserEntity;
import com.web.pathfinder.model.enums.LevelEnum;
import com.web.pathfinder.repository.UserRepository;
import com.web.pathfinder.service.UserService;
import com.web.pathfinder.util.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterBindingModel) {
        userRepository.save(map(userRegisterBindingModel));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
       UserEntity userEntity = userRepository
               .findByUsername(userLoginDTO.getUsername())
               .orElse(null);

       if (userEntity != null) {
           currentUser.setUsername(userEntity.getUsername());
           currentUser.setLogged(true);
           currentUser.setAge(userEntity.getAge());
           currentUser.setEmail(userEntity.getEmail());
           currentUser.setFullName(userEntity.getFullName());
           currentUser.setLevel(userEntity.getLevel());
           currentUser.setLevel(userEntity.getLevel());
       }

       return currentUser.isLogged();
    }

    private UserEntity map(UserRegisterDTO userRegisterDTO) {
        UserEntity user = new UserEntity();

        user.setUsername(userRegisterDTO.getUsername());
        user.setFullName(userRegisterDTO.getFullName());
        user.setAge(userRegisterDTO.getAge());
        user.setEmail(userRegisterDTO.getEmail());
        user.setLevel(LevelEnum.BEGINNER);
        user.setPassword(userRegisterDTO.getPassword());
        return user;
    }
}
