package com.ayata.ayatamart.dto.response;


public class ProductModelResponse {
    private int productId;
    private String productName;
    private int price;
    private String image;
    private String description;
    private int stock;

    public ProductModelResponse() {
    }

    public ProductModelResponse(int productId, String productName, int price, String image, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.description = description;

    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
