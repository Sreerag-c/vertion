
package com.ayata.ayatamart.model;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int stockId;
    @Column(name = "productId")
    private int productId;
    @Column(name = "stock")
    private int stock;

    public Stock() {
    }

    public Stock(int stockId, int productId, int stock) {
        this.stockId = stockId;
        this.productId = productId;
        this.stock = stock;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

