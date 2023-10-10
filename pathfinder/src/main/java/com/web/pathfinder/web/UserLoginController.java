package com.web.pathfinder.web;

import com.web.pathfinder.model.dto.UserLoginDTO;
import com.web.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {

        boolean isLogged = userService.loginUser(userLoginDTO);

        return isLogged ? "index" : "login";
    }
}
