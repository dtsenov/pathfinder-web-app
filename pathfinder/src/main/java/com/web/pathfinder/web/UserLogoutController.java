package com.web.pathfinder.web;

import com.web.pathfinder.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLogoutController {

    private final UserServiceImpl userService;

    public UserLogoutController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout() {

        userService.logoutUser();

        return "redirect:/";
    }
}
