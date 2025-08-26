package com.worknest.dao.impl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worknest.dao.TaskDao;
import com.worknest.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(task);
        tx.commit();
        session.close();
    }

    public Task findById(int id) {
        Session session = sessionFactory.openSession();
        Task task = session.get(Task.class, id);
        session.close();
        return task;
    }

    public List<Task> findAll() {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.createQuery("from Task", Task.class).list();
        session.close();
        return tasks;
    }

    public List<Task> findByUserId(int userId) {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.createQuery("from Task where user.id = :userId", Task.class)
                                  .setParameter("userId", userId)
                                  .list();
        session.close();
        return tasks;
    }

    public void update(Task task) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(task);
        tx.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Task task = session.get(Task.class, id);
        if (task != null) {
            session.delete(task);
        }
        tx.commit();
        session.close();
    }
}
