package com.ayata.ayatamart.service;

import com.ayata.ayatamart.dto.request.ProductRequest;
import com.ayata.ayatamart.dto.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;


public interface ProductService {
    ProductResponse addToProduct(ProductRequest productRequest);

    void deleteFromProducts(String token, int productId);

    String uploadImage(MultipartFile file);
}
