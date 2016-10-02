package com.fotix.auth.repository;

import com.fotix.auth.model.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by herasimau on 07.08.16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
