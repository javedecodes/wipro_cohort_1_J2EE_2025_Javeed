package com.worknest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.worknest.model.Task;
import com.worknest.model.TaskStatus;
import com.worknest.model.User;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam Long userId, Model model) {
        User user = userService.get(userId);
        if (user != null) {
            model.addAttribute("user", user);
            List<Task> tasks = taskService.getByUser(userId);
            model.addAttribute("tasks", tasks);
            return "user/dashboard";
        }
        return "redirect:/auth/login";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long taskId,
                               @RequestParam String status,
                               @RequestParam Long userId) {

        Task task = taskService.get(taskId);

        // Ensure the task exists and the logged-in user is the assigned user
        if (task != null && task.getAssignedUser() != null
                && task.getAssignedUser().getId().equals(userId)) {

            try {
                // Convert string to TaskStatus enum safely
                TaskStatus newStatus = TaskStatus.valueOf(status.toUpperCase());
                task.setStatus(newStatus);

                // Update task in DB
                taskService.update(task);

            } catch (IllegalArgumentException e) {
                // Invalid status provided
                System.out.println("Invalid task status: " + status);
            }
        }

        return "redirect:/user/dashboard?userId=" + userId;
    }
}
