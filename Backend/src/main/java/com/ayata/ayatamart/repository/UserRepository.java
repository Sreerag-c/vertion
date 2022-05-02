package com.ayata.ayatamart.repository;


import com.ayata.ayatamart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmployeeId(Integer employeeId);

    Optional<User> findByUsernameAndPassword(String username, String password);
}

