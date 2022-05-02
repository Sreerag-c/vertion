package com.ayata.ayatamart.dto.request;

public class OrderStatusRequest {
    int orderId;
    String status;

    public OrderStatusRequest() {

    }

    public OrderStatusRequest(int orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
