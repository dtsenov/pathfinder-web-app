package com.web.pathfinder.web;

import com.web.pathfinder.model.dto.UserRegisterDTO;
import com.web.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterBindingModel) {

        userService.registerUser(userRegisterBindingModel);

        return "redirect:/";
    }
}
