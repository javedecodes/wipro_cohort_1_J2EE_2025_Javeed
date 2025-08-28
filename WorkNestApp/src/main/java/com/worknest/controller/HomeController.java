package com.worknest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Root URL
    @GetMapping("/")
    public String home() {
        // Redirect to the login page
        return "redirect:/auth/login";
    }
}
