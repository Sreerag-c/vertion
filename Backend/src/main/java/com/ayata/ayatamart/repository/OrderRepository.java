package com.ayata.ayatamart.repository;

import com.ayata.ayatamart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByEmployeeId(Integer employeeId);

    Optional<Order> findByOrderId(Integer OrderId);
}
