
package com.ayata.ayatamart.repository;

import com.ayata.ayatamart.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StockRepository extends JpaRepository <Stock, Integer >{
     Optional<Stock> findByProductId(int productId);

}

