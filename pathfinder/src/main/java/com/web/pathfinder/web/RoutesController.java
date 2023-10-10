package com.web.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutesController {

    @GetMapping("/routes")
    public String getAllRoutes() {
        return "routes";
    }
}
