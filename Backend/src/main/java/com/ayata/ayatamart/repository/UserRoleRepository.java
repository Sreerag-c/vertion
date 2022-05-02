package com.ayata.ayatamart.repository;

import com.ayata.ayatamart.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByEmployeeId(Integer employeeId);
}
