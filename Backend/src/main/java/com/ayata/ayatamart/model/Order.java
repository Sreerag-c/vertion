package com.ayata.ayatamart.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "total_amount")
    private int totalAmt;

    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Order(int employeeId, int productId, int totalAmt, String status) {
        this.employeeId = employeeId;
        this.productId = productId;
        this.totalAmt = totalAmt;
        this.status = status;
    }

    public Order(int orderId, int employeeId, int productId, int totalAmt, String address, String status) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.productId = productId;
        this.totalAmt = totalAmt;
        this.status = status;
    }

    public Order(int employeeId, int productId, int totalAmt, String address, String status) {
        this.employeeId = employeeId;
        this.productId = productId;
        this.totalAmt = totalAmt;
        this.status = status;
    }

    public Order(int employeeId, int productId, int totalAmt) {
        this.employeeId = employeeId;
        this.productId = productId;
        this.totalAmt = totalAmt;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public int getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(int totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
