package com.worknest.controller;



import com.worknest.model.Task;
import com.worknest.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // View single Task
    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "admin/task";
    }

    // Delete Task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return "redirect:/admin/dashboard";
    }
}
