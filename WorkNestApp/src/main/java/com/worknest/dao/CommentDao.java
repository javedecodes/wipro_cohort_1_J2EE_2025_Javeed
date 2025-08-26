package com.worknest.dao;



import java.util.List;
import com.worknest.model.Comment;

public interface CommentDao {
    void save(Comment comment);
    Comment findById(int id);
    List<Comment> findByTaskId(int taskId);  
    void delete(int id);
}
