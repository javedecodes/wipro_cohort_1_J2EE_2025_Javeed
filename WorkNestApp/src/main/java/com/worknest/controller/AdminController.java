package com.worknest.controller;



import com.worknest.model.User;
import com.worknest.model.Task;
import com.worknest.service.UserService;
import com.worknest.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    // Admin Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "admin/dashboard";
    }

    // List Users
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    // Show Add User form
    @GetMapping("/add-user")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add-user";
    }

    // Save User
    @PostMapping("/add-user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/admin/users";
    }

    // Assign Task
    @GetMapping("/assign-task")
    public String showAssignTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.getAllUsers());
        return "admin/tasks";
    }

    @PostMapping("/assign-task")
    public String assignTask(@ModelAttribute("task") Task task) {
        taskService.createTask(task);
        return "redirect:/admin/dashboard";
    }
}
