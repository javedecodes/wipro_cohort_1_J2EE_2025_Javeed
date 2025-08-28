package com.worknest.serviceImpl;

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
    public User login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> listAll() {
        return userDao.findAll();
    }

    @Override
    public User get(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
