package com.worknest;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.worknest.dao.UserDao;
import com.worknest.model.User;
import com.worknest.service.impl.UserServiceImpl;

class UserServiceTest<userDao> {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setUsername("testUser");
        userService.register(user);
        verify(userDao, times(1)).save(user);
    }

    @Test
    void testLoginUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("1234");
        when(userDao.findByUsernameAndPassword("testUser", "1234")).thenReturn(user);
        User loggedIn = userService.login("testUser", "1234");
        assertNotNull(loggedIn);
        assertEquals("testUser", loggedIn.getUsername());
    }
}