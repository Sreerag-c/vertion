
package com.ayata.ayatamart.dto.request;

public class StockRequest {
    private int productId;
    private int stock;

    public StockRequest() {
    }

    public StockRequest(int productId, int stock) {
        this.productId = productId;
        this.stock = stock;
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

