package com.ayata.ayatamart.service.serviceimpl;

import com.ayata.ayatamart.dto.request.CartRequestModel;
import com.ayata.ayatamart.dto.request.SelectionRequest;
import com.ayata.ayatamart.dto.response.PlpResponse;
import com.ayata.ayatamart.dto.response.ProductModelResponse;
import com.ayata.ayatamart.exception.InvalidUserException;
import com.ayata.ayatamart.exception.ResourceNotFoundException;
import com.ayata.ayatamart.model.Cart;
import com.ayata.ayatamart.model.Product;
import com.ayata.ayatamart.model.Stock;
import com.ayata.ayatamart.repository.CartRepository;
import com.ayata.ayatamart.repository.ProductRepository;
import com.ayata.ayatamart.repository.StockRepository;
import com.ayata.ayatamart.repository.UserRepository;
import com.ayata.ayatamart.service.PlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlpServiceImpl implements PlpService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public PlpResponse listProducts() {

        PlpResponse plpResponse = new PlpResponse();
        List<ProductModelResponse> productModelResponseList = new ArrayList<>();

        List<Product> products = productRepository.findAll();

        for (Product product : products) {

            Optional<Product> optionalProducts = productRepository.findByProductId(product.getProductId());
            Optional<Stock> optionalStock = stockRepository.findByProductId(product.getProductId());
            ProductModelResponse productModelResponse = new ProductModelResponse();
            productModelResponse.setProductId(product.getProductId());
            productModelResponse.setProductName(product.getProductName());
            productModelResponse.setPrice(product.getPrice());
            productModelResponse.setImage(product.getImage());
            productModelResponse.setDescription(product.getDescription());
            productModelResponse.setStock(optionalStock.get().getStock());
            productModelResponseList.add(productModelResponse);

        }
        plpResponse.setProductModelResponse(productModelResponseList);
        return plpResponse;
    }

    @Override
    public int getCartCount(int employeeId) {
        return cartRepository.findByEmployeeId(employeeId).size();

    }

    @Override
    public Void addToCart(int employeeId, SelectionRequest selectionRequest) {
        Optional<Product> plpOptional = productRepository.findByProductId(selectionRequest.getProductId());
        CartRequestModel cartRequestModel = new CartRequestModel();
        if (plpOptional.isPresent()) {
            cartRequestModel.setEmployeeId(employeeId);
            int amount = plpOptional.get().getPrice();
            int quantity = selectionRequest.getQuantity();
            int price = amount * quantity;
            cartRequestModel.setPrice(price);
            cartRequestModel.setQuantity(quantity);
            cartRequestModel.setProductId(selectionRequest.getProductId());

        } else {
            throw new ResourceNotFoundException("Product", "productId");
        }
        Optional<Cart> cart = cartRepository.findByEmployeeIdAndProductId(cartRequestModel.getEmployeeId(), cartRequestModel.getProductId());
        if (!cart.isPresent()) {
            cartRepository.save(new Cart(cartRequestModel.getEmployeeId(), cartRequestModel.getProductId(), cartRequestModel.getQuantity(), cartRequestModel.getPrice()));
        } else {
            throw new InvalidUserException(cartRequestModel.getEmployeeId());
        }
        return null;

    }


}

