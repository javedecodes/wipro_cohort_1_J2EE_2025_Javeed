package com.worknest;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;
import com.worknest.service.impl.TaskServiceImpl;

class TaskServiceTest {

    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private TaskDao taskDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setTitle("New Task");
        taskService.createTask(task);
        verify(taskDao, times(1)).save(task);
    }

    @Test
    void testGetAllTasks() {
        Task t1 = new Task();
        Task t2 = new Task();
        when(taskDao.findAll()).thenReturn(Arrays.asList(t1, t2));
        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
        verify(taskDao, times(1)).findAll();
    }
}