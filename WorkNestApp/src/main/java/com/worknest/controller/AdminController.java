package com.worknest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userService.listAll());
        model.addAttribute("tasks", taskService.getAll());
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.listAll());
        return "admin/users";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) {
        if (task.getAssignedUser() != null && task.getAssignedUser().getEmail() != null) {
            User assignedUser = userService.getByEmail(task.getAssignedUser().getEmail());
            task.setAssignedUser(assignedUser);
        }
        taskService.create(task);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("comments", commentService.listAll());
        return "admin/comments";
    }
}
