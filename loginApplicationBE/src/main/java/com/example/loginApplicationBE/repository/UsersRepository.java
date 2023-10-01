package com.example.loginApplicationBE.repository;

import com.example.loginApplicationBE.dtos.response.UserDetailsDto;
import com.example.loginApplicationBE.dtos.response.UserList;
import com.example.loginApplicationBE.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsernameAndPassword(String username, String password);

    @Query (value = "SELECT u.userId as userId, u.username as username, u.name as name, r.roleName as role FROM Users u JOIN UsersRole ur ON ur.user.userId = u.userId"
    + " JOIN Role r ON r.roleId = ur.role.roleId")
    List<UserList> findAllUser();
}
