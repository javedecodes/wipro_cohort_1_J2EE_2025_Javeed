package com.worknest.dao;

import com.worknest.model.Task;
import java.util.List;

public interface TaskDao {
    void save(Task task);
    Task findById(int id);
    List<Task> findAll();
    List<Task> findByUserId(int userId);
    void update(Task task);
    void delete(int id);
}
