package com.fotix.api.repository;

import com.fotix.api.entities.user.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by herasimau on 02/10/16.
 */
@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority,Long> {
}
