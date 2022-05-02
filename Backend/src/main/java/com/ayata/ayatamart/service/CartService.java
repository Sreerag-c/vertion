package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.response.CartResponse;

public interface CartService {
    CartResponse listCart(Integer employeeId);

    void removeFromCart(Integer employeeId);

    void confirmOrder(Integer employeeId);
}
