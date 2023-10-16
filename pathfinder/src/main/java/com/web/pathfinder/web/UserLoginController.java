package com.web.pathfinder.web;

import com.web.pathfinder.model.binding.UserLoginBindingModel;
import com.web.pathfinder.model.service.UserServiceModel;
import com.web.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    @ModelAttribute
    public UserLoginBindingModel userRegisterBindingModel() {
        return new UserLoginBindingModel();
    }

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("isExists", true);

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

                if (user == null) {
                    redirectAttributes
                            .addFlashAttribute("isExists", false)
                            .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                            .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

                    return "redirect:login";
                }

        userService.loginUser(user.getId(), user.getUsername());

        return  "redirect:/";
    }
}
