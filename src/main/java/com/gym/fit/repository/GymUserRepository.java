package com.gym.fit.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.GymUser;

@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long> {
    Optional<GymUser> findByUsernameOrEmail(String username, String email);


}
