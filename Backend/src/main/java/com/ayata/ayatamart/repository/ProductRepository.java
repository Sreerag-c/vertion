package com.ayata.ayatamart.repository;

import com.ayata.ayatamart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByProductId(Integer productId);
    Optional<Product> findByProductName(String productName);
}
