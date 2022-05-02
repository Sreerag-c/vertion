package com.ayata.ayatamart.repository;

import com.ayata.ayatamart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByEmployeeId(Integer employeeId);

    Optional<Cart> findByEmployeeIdAndProductId(Integer employeeId, Integer productId);

}
