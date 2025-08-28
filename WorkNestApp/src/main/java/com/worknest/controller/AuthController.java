package com.worknest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.worknest.model.User;
import com.worknest.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    
    
    
    @GetMapping("/ping")
    public String ping() {
        return "auth/login"; 
    }

    /** Show Login Page */
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login"; // JSP: /WEB-INF/views/auth/login.jsp
    }

    /** Handle Login */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            session.setAttribute("currentUser", user);
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/user/dashboard?userId=" + user.getId();
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "auth/login";
        }
    }

    /** Show Registration Page */
    @GetMapping("/register")
    public String registerPage() {
        return "auth/register"; // JSP: /WEB-INF/views/auth/register.jsp
    }

    /** Handle Registration */
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        user.setRole("USER"); // default role
        userService.register(user);
        model.addAttribute("success", "Registration successful! Please login.");
        return "auth/login";
    }

    /** Handle Logout */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "auth/logout"; // JSP: /WEB-INF/views/auth/logout.jsp
    }
}
