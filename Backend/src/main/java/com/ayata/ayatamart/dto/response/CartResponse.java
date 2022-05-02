package com.ayata.ayatamart.dto.response;


import java.util.List;

public class CartResponse {

    private List<CartModelResponse> cartModelResponses;


    public List<CartModelResponse> getCartModelResponses() {
        return cartModelResponses;
    }

    public void setCartModelResponses(List<CartModelResponse> cartModelResponses) {
        this.cartModelResponses = cartModelResponses;
    }

    public CartResponse() {
    }

    public CartResponse(List<CartModelResponse> cartModelResponses) {
        this.cartModelResponses = cartModelResponses;
    }

}
