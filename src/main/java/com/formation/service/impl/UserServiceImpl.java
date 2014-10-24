package com.formation.service.impl;

import com.formation.dao.UserDAO;
import com.formation.model.User;
import com.formation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chris on 23/10/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Iterable<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public User getUser(Long userId) {
        return userDAO.findOne(Long.valueOf(userId));
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
