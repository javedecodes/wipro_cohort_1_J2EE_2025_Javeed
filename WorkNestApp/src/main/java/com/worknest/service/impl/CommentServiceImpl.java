package com.worknest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;
import com.worknest.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void addComment(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public Comment getCommentById(int id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> getCommentsByTaskId(int taskId) {
        return commentDao.findByTaskId(taskId);
    }

    @Override
    public void deleteComment(int id) {
        commentDao.delete(id);
    }
}
