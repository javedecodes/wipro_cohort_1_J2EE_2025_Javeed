package com.worknest.serviceImpl;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;
import com.worknest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void create(Task task) {
        taskDao.save(task);
    }

    @Override
    public void update(Task task) {
        taskDao.save(task);
    }

    @Override
    public Task get(Long id) {
        return taskDao.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskDao.findAll();
    }

    @Override
    public List<Task> getByUser(Long userId) {
        return taskDao.findByUserId(userId);
    }
}
