
package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.request.StockRequest;
import com.ayata.ayatamart.model.Stock;

public interface StockService {
    public void updateStock(StockRequest request);
}

