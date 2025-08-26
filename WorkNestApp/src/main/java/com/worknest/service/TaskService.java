package com.worknest.service;



import java.util.List;
import com.worknest.model.Task;

public interface TaskService {
    void createTask(Task task);
    Task getTaskById(int id);
    List<Task> getAllTasks();
    List<Task> getTasksByUserId(int userId);   // ✅ add this
    void updateTask(Task task);
    void deleteTask(int id);
}
