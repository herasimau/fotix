package com.fotix.api.repository;

import com.fotix.api.entities.user.User;
import com.fotix.api.entities.verification.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by herasimau on 01/10/16.
 */
@Repository

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {


    Optional<VerificationToken> findByToken(String token);

    VerificationToken findByUser(User user);
}
