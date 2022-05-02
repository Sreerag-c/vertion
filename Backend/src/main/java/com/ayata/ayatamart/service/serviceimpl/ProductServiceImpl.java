package com.ayata.ayatamart.service.serviceimpl;

import com.ayata.ayatamart.dto.request.ProductRequest;
import com.ayata.ayatamart.dto.response.ProductResponse;
import com.ayata.ayatamart.exception.ProductAlreadyExistException;
import com.ayata.ayatamart.exception.ProductNotFoundException;
import com.ayata.ayatamart.model.Product;
import com.ayata.ayatamart.model.Stock;
import com.ayata.ayatamart.repository.ProductRepository;
import com.ayata.ayatamart.repository.StockRepository;
import com.ayata.ayatamart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;

    @Override
    public ProductResponse addToProduct(ProductRequest productRequest) {
        Product product = new Product();
        Stock stock = new Stock();
        product.setProductName(productRequest.getProductName());
        product.setImage(productRequest.getImage());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);
        Optional<Product> productOptional = productRepository.findByProductName(productRequest.getProductName());
        if (productOptional.isPresent()) {
            stock.setProductId(productOptional.get().getProductId());
            stock.setStock(productRequest.getStock());
            stockRepository.save(stock);
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductId(productOptional.get().getProductId());
            productResponse.setDescription(productOptional.get().getDescription());
            productResponse.setProductName(productOptional.get().getProductName());
            productResponse.setPrice(productOptional.get().getPrice());
            productResponse.setStock(productRequest.getStock());
            return productResponse;
        } else
            throw new ProductAlreadyExistException(productRequest.getProductName());
    }

    public void deleteFromProducts(String token, int productId) {
        if (!productRepository.findByProductId(productId).isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        Optional<Product> product = productRepository.findByProductId(productId);
        productRepository.delete(product.get());
    }

    @Override
    public String uploadImage(MultipartFile file) {
        String fileName = null;
        File newfile = new File("C:\\Users\\RishiMohan\\OneDrive - AyataCommerce\\Documents\\AyataMart Project\\team-two-demo\\FrontEnd\\images\\" + file.getOriginalFilename());

        try {
            if (newfile.createNewFile()) {
                FileOutputStream fos = new FileOutputStream(newfile);
                fos.write(file.getBytes());
                fos.close();
                fileName = file.getOriginalFilename();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
