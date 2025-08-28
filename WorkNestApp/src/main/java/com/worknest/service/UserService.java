package com.worknest.service;

import com.worknest.model.User;
import java.util.List;

public interface UserService {

    void register(User user);

    User get(Long id);

    List<User> listAll();

    User getByEmail(String email);

    // Add this method
    User login(String username, String password);
}
