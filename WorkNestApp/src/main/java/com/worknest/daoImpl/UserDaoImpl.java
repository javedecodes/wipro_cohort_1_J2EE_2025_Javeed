package com.worknest.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
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
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User", User.class)
                .list();
    }

    @Override
    public User findByEmail(String email) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User findByUsername(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();
    }
}
