package com.worknest.service;

import java.util.List;
import com.worknest.model.Comment;

public interface CommentService {
    void addComment(Comment comment);
    Comment getCommentById(int id);
    List<Comment> getCommentsByTaskId(int taskId);   
    void deleteComment(int id);
}
