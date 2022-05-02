package com.ayata.ayatamart.dto.request;

public class ProductRequest {
    private String productName;
    private int price;
    private String description;
    private int stock;
    private String image;

    public ProductRequest() {
    }

    public ProductRequest(String productName, int price, String description, int stock, String image) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProductId() {
        return 0;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
