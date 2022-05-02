package com.ayata.ayatamart.controller;

import com.ayata.ayatamart.dto.response.PlpResponse;
import com.ayata.ayatamart.dto.request.SelectionRequest;
import com.ayata.ayatamart.dto.response.UserRoleResponse;
import com.ayata.ayatamart.exception.InvalidUserException;
import com.ayata.ayatamart.service.PlpService;
import com.ayata.ayatamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ayatamart")
public class PlpController {

    @Autowired
    private PlpService plpService;

    @Autowired
    private UserService userService;



    @GetMapping("/products")
    public ResponseEntity<PlpResponse> listProducts(@RequestHeader("token") String token) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);

        if (userRoleResponse == null) {
            throw new InvalidUserException(userRoleResponse.getEmployeeId());
        }
        PlpResponse plpResponse = plpService.listProducts();
        return new ResponseEntity<>(plpResponse, HttpStatus.OK);
    }


    @GetMapping("/products/cartcount")
    public ResponseEntity<Integer> cartCount(@RequestHeader("token") String token) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);

        if (userRoleResponse == null||userRoleResponse.getRole().equals("admin")) {
            throw new InvalidUserException(userRoleResponse.getEmployeeId());
        }
        int cartCount = plpService.getCartCount(userRoleResponse.getEmployeeId());
        return new ResponseEntity<>(cartCount, HttpStatus.OK);

    }

    @PostMapping("/cart/products")
    public ResponseEntity<Void> addToCart(@RequestHeader("token") String token, @RequestBody SelectionRequest selectionRequest) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("admin")) {
            throw new InvalidUserException(userRoleResponse.getEmployeeId());
        }
        plpService.addToCart(userRoleResponse.getEmployeeId(), selectionRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

