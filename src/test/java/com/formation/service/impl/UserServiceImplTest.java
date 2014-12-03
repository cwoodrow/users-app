package com.formation.service.impl;

import com.formation.dao.UserDAO;
import com.formation.model.User;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    public static final long USER_ID = 42l;
    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl testedObject;
    private User user;


    @Before
    public void before() {
        testedObject = new UserServiceImpl();
        user = new User();
        user.setId(USER_ID);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCallDelete() {
        testedObject.delete(user);

        verify(userDAO, times(1)).delete(user);
    }

    @Test
    public void shouldCallSave() {
        testedObject.save(user);

        verify(userDAO, times(1)).save(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSaveNullUser() {
        testedObject.save(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDeleteNullUser() {
        testedObject.delete(null);
    }


    @Test
    public void shouldFindAllUsers() {
        User user2 = new User();
        when(userDAO.findAll()).thenReturn(Arrays.asList(user, user2));

        Iterable<User> allUsers = testedObject.getAllUsers();

        List<User> users = Lists.newArrayList(allUsers);
        assertEquals(2, users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user2));
        verify(userDAO, times(1)).findAll();
    }

    @Test
    public void shouldFindOneUser() {
        when(userDAO.findOne(USER_ID)).thenReturn(user);

        User returnedUser = testedObject.getUser(USER_ID);

        assertEquals(user, returnedUser);
        verify(userDAO, times(1)).findOne(USER_ID);
    }


}
