package com.worknest.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.worknest.model.Task;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    // View My Tasks
    @GetMapping("/tasks/{userId}")
    public String viewTasks(@PathVariable int userId, Model model) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        model.addAttribute("tasks", tasks);
        return "users/tasks";
    }

    // Update Task Status
    @PostMapping("/update-status")
    public String updateTaskStatus(@RequestParam int taskId,
                                   @RequestParam String status,
                                   @RequestParam int userId) {
        Task task = taskService.getTaskById(taskId);
        task.setStatus(status);
        taskService.updateTask(task);
        return "redirect:/user/tasks/" + userId;
    }
}
