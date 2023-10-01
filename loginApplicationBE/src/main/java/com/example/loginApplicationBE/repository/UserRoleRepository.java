package com.example.loginApplicationBE.repository;

import com.example.loginApplicationBE.model.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UsersRole, Long> {
    Optional<UsersRole> findByUserUserId(Long userId);
}
