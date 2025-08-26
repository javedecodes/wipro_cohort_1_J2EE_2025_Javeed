package com.worknest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worknest.dao.UserDao;
import com.worknest.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.openSession();
        User user = session.createQuery("from User where email = :email", User.class)
                           .setParameter("email", email)
                           .uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        User user = session.createQuery("from User where username = :username and password = :password", User.class)
                           .setParameter("username", username)
                           .setParameter("password", password)
                           .uniqueResult();
        session.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        session.close();
        return users;
    }
}
