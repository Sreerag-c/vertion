package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.request.OrderStatusRequest;
import com.ayata.ayatamart.dto.response.OrderResponse;

public interface OrderService {
    OrderResponse listOrders(Integer employeeId);

    void updateOrderStatus(OrderStatusRequest orderStatusRequest);


}