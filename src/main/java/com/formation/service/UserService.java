package com.formation.service;

import com.formation.model.User;

/**
 * Created by Chris on 23/10/14.
 */
public interface UserService {
    Iterable<User> getAllUsers();

    void save(User user);

    User getUser(Long userId);

    void delete(User user);
}
