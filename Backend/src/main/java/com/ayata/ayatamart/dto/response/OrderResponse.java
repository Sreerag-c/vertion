package com.ayata.ayatamart.dto.response;

import java.util.List;

public class OrderResponse {
    private List<OrderModelResponse> orderModelResponses;

    public List<OrderModelResponse> getOrderModelResponses() {
        return orderModelResponses;
    }

    public void setOrderModelResponses(List<OrderModelResponse> orderModelResponses) {
        this.orderModelResponses = orderModelResponses;
    }

    public OrderResponse(List<OrderModelResponse> orderModelResponses) {
        this.orderModelResponses = orderModelResponses;
    }

    public OrderResponse() {
    }

}