
package com.ayata.ayatamart.service.serviceimpl;

import com.ayata.ayatamart.dto.request.StockRequest;
import com.ayata.ayatamart.exception.ProductNotFoundException;
import com.ayata.ayatamart.model.Stock;
import com.ayata.ayatamart.repository.ProductRepository;
import com.ayata.ayatamart.repository.StockRepository;
import com.ayata.ayatamart.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void updateStock(StockRequest stockRequest) {
        if (!(productRepository.findByProductId(stockRequest.getProductId()).isPresent())) {
            throw new ProductNotFoundException("Product not found");
        }
        Optional<Stock> stockOptional = stockRepository.findByProductId(stockRequest.getProductId());

        Stock stockModel = stockOptional.get();
        stockModel.setStock(stockRequest.getStock());
        stockRepository.save(stockModel);


    }
}

