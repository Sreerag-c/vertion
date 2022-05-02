package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.response.PlpResponse;
import com.ayata.ayatamart.dto.request.SelectionRequest;

public interface PlpService {

    PlpResponse listProducts();

    int getCartCount(int employeeId);

    Void addToCart(int employeeId, SelectionRequest selectionRequest);


}
