package com.ayata.ayatamart.dto.response;

public class ProductResponse {
    private int productId;
    private String productName;
    private String image;
    private int price;
    private String description;
    private int stock;


    public ProductResponse(int productId, String productName, String image, int price, String description, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public ProductResponse() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
