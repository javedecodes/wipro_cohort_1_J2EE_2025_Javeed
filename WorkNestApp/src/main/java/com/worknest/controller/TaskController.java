package com.worknest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.worknest.model.Comment;
import com.worknest.model.Task;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    /** Show Task Details with Comments */
    @GetMapping("/{taskId}")
    public String taskDetail(@PathVariable Long taskId, Model model) {
        Task task = taskService.get(taskId);
        if (task != null) {
            model.addAttribute("task", task);
            model.addAttribute("comments", commentService.getCommentsByTask(taskId));
            return "user/tasks"; // JSP: /WEB-INF/views/user/tasks.jsp
        }
        return "redirect:/user/dashboard";
    }

    /** Add Comment to Task */
    @PostMapping("/{taskId}/comment")
    public String addComment(@PathVariable Long taskId,
                             @ModelAttribute Comment comment) {
        Task task = taskService.get(taskId);
        if (task != null) {
            comment.setTask(task);
            commentService.addComment(comment);
        }
        return "redirect:/tasks/" + taskId;
    }
}
