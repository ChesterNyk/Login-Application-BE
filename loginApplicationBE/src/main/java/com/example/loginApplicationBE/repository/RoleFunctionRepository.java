package com.example.loginApplicationBE.repository;

import com.example.loginApplicationBE.model.RoleFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleFunctionRepository extends JpaRepository<RoleFunction, Long> {
    List<RoleFunction> findByRoleRoleId(Long roleId);
}
