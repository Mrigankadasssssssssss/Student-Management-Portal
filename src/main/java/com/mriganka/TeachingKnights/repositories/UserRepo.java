package com.mriganka.TeachingKnights.repositories;

import com.mriganka.TeachingKnights.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
