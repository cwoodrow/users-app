package com.formation.dao;

import com.formation.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chris on 23/10/14.
 */
public interface UserDAO extends CrudRepository<User, Long> {
}
