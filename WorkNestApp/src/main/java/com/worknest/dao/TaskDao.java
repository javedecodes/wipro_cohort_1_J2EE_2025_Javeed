package com.worknest.dao;

import com.worknest.model.Task;
import java.util.List;

public interface TaskDao {
    void save(Task task);
    Task findById(Long id);
    List<Task> findAll();
    List<Task> findByUserId(Long userId);
}
