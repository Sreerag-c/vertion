package com.ayata.ayatamart.dto.response;

public class OrderModelResponse {

    private String image;
    private String productName;
    private int totalAmount;
    private String status;
    private int employeeId;
    private int productId;
    private int orderId;
    private String employeeName;

    public OrderModelResponse() {
    }

    public OrderModelResponse(String image, String employeeName, String productName, int totalAmount, String status, String address, int employeeId, int productId, int orderId) {
        this.image = image;
        this.productName = productName;
        this.employeeName = employeeName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.employeeId = employeeId;
        this.productId = productId;
        this.orderId = orderId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }


}