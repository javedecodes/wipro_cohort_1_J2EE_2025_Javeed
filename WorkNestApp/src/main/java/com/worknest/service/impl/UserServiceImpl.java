package com.worknest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.worknest.dao.UserDao;
import com.worknest.model.User;
import com.worknest.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userDao.findByEmail(email);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
