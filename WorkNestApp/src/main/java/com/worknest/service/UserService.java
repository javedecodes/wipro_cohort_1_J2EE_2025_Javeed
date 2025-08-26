package com.worknest.service;



import com.worknest.model.User;
import java.util.List;

public interface UserService {
    void register(User user);
    User login(String email, String password);
    List<User> getAllUsers();
}
