package com.ayata.ayatamart.service.serviceimpl;
import com.ayata.ayatamart.dto.response.CartModelResponse;
import com.ayata.ayatamart.dto.response.CartResponse;
import com.ayata.ayatamart.exception.ResourceNotFoundException;
import com.ayata.ayatamart.model.Cart;
import com.ayata.ayatamart.model.Order;
import com.ayata.ayatamart.model.Product;
import com.ayata.ayatamart.repository.CartRepository;
import com.ayata.ayatamart.repository.OrderRepository;
import com.ayata.ayatamart.repository.ProductRepository;
import com.ayata.ayatamart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartResponse listCart(Integer employeeId) {

        CartResponse cartResponse = new CartResponse();
        List<CartModelResponse> cartModelResponseList = new ArrayList<CartModelResponse>();
        List<Cart> carts = cartRepository.findByEmployeeId(employeeId);
        for (Cart cart : carts) {
            CartModelResponse cartModelResponse = new CartModelResponse();
            Optional<Product> optionalProducts = productRepository.findByProductId(cart.getProductId());
            if (optionalProducts.isPresent()) {
                cartModelResponse.setImage(optionalProducts.get().getImage());
                cartModelResponse.setProductName(optionalProducts.get().getProductName());
            } else {
                throw new ResourceNotFoundException("Product", "productId", cart.getProductId());
            }


            cartModelResponse.setQuantity(cart.getQuantity());
            cartModelResponse.setPrice(cart.getPrice());
            cartModelResponseList.add(cartModelResponse);
            cartResponse.setCartModelResponses(cartModelResponseList);
        }
        return cartResponse;
    }

    @Override
    public void removeFromCart(Integer employeeId) {
        List<Cart> carts = cartRepository.findByEmployeeId(employeeId);
        for (Cart cart : carts) {
            cartRepository.delete(cart);
        }
    }

    @Override
    public void confirmOrder(Integer employeeId) {
        List<Cart> carts = cartRepository.findByEmployeeId(employeeId);
        if (carts.size() != 0) {
            for (Cart cart : carts) {
                orderRepository.save(new Order(cart.getEmployeeId(), cart.getProductId(), cart.getPrice(), "Waiting for approval"));
            }
        } else throw new ResourceNotFoundException();
    }


}