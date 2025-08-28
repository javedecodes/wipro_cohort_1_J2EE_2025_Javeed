package com.worknest.service;

import com.worknest.model.Task;
import java.util.List;

public interface TaskService {
    void create(Task task);
    void update(Task task);
    Task get(Long id);
    List<Task> getAll();
    List<Task> getByUser(Long userId);
}
