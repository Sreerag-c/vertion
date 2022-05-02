package com.ayata.ayatamart.dto.request;

public class CartRequestModel {
    int employeeId;
    int productId;
    int price;
    int quantity;

    public CartRequestModel() {
    }

    public CartRequestModel(int employeeId, int productId, int price, int quantity) {
        this.employeeId = employeeId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice(int price) {
        return price;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
