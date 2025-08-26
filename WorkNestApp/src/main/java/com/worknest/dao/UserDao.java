package com.worknest.dao;







import java.util.List;
import com.worknest.model.User;

public interface UserDao {
    void save(User user);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);
    List<User> findAll();
}
