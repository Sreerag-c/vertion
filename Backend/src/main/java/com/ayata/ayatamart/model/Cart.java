package com.ayata.ayatamart.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "employeeId")
    private int employeeId;
    @Column(name = "product_id")
    private int productId;
    @Column
    private int quantity;
    @Column
    private int price;

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cart(int id, int employeeId, int productId, int quantity, int price) {
        this.id = id;
        this.employeeId = employeeId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Cart(int employeeId, int productId, int quantity, int price) {
        this.employeeId = employeeId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
