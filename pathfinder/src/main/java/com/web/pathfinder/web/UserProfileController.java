package com.web.pathfinder.web;

import com.web.pathfinder.model.view.UserViewModel;
import com.web.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserProfileController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserProfileController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model) {

        model
                .addAttribute("user",
                        modelMapper.map(userService.findById(id), UserViewModel.class));

        return "profile";
    }
}
