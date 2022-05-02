package com.ayata.ayatamart.controller;


import com.ayata.ayatamart.dto.request.ProductRequest;
import com.ayata.ayatamart.dto.response.ProductResponse;
import com.ayata.ayatamart.exception.InvalidUserException;

import com.ayata.ayatamart.dto.response.UserRoleResponse;

import com.ayata.ayatamart.service.ProductService;
import com.ayata.ayatamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@RequestMapping("/ayatamart")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;


    @PostMapping("/products")
    public ResponseEntity<ProductResponse> addToProduct(@RequestHeader("token") String token, @RequestBody ProductRequest productRequest) {
       UserRoleResponse userRoleResponse= new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("employee")) {
            throw new InvalidUserException(userRoleResponse.getEmployeeId());
        }
        ProductResponse productResponse = new ProductResponse();
        productResponse = productService.addToProduct(productRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProducts(@RequestHeader("token") String token, @PathVariable int productId) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("employee")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        productService.deleteFromProducts(token, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/products/image")
    public ResponseEntity<String> uploadImage(@RequestHeader("token") String token, @RequestParam("File") MultipartFile file) {
        UserRoleResponse userRoleResponse=new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("employee")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        String service = productService.uploadImage(file);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else
            return new ResponseEntity<>(service, HttpStatus.CREATED);
    }


}
