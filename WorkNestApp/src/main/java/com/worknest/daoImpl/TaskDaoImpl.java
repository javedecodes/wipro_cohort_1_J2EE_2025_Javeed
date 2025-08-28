package com.worknest.daoImpl;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Task task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
    }

    @Override
    public Task findById(Long id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Task", Task.class)
                .list();
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Task t WHERE t.assignedUser.id = :userId", Task.class)
                .setParameter("userId", userId)
                .list();
    }
}
