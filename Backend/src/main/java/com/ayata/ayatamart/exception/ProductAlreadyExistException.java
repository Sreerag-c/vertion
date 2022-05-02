package com.ayata.ayatamart.exception;

public class ProductAlreadyExistException extends RuntimeException{
    String productName;

    public ProductAlreadyExistException(String productName) {
        super("ProductExists");
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
