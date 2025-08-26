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
import com.worknest.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // View comments for a Task
    @GetMapping("/task/{taskId}")
    public String getCommentsByTask(@PathVariable int taskId, Model model) {
        model.addAttribute("comments", commentService.getCommentsByTaskId(taskId));
        return "admin/comments";
    }

    // Add Comment
    @PostMapping("/add")
    public String addComment(@ModelAttribute("comment") Comment comment) {
        commentService.addComment(comment);
        return "redirect:/user/tasks/" + comment.getUser().getId();
    }

    // Delete Comment
    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
        return "redirect:/admin/comments";
    }
}
