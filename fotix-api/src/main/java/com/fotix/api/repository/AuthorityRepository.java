package com.fotix.api.repository;

import com.fotix.api.entities.authority.Authority;
import com.fotix.api.entities.authority.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by herasimau on 02/10/16.
 */
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority getByName(AuthorityName name);
}
