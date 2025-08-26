package com.worknest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;
import com.worknest.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    public void createTask(Task task) {
        taskDao.save(task);
    }

    public Task getTaskById(int id) {
        return taskDao.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }

    public List<Task> getTasksByUser(int userId) {
        return taskDao.findByUserId(userId);
    }

    @Override
    public void updateTask(Task task) {
        taskDao.update(task);
    }

    @Override
    public void deleteTask(int id) {
        taskDao.delete(id);
    }

	@Override
	public List<Task> getTasksByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
