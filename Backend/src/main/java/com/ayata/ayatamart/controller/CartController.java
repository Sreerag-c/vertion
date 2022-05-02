package com.ayata.ayatamart.controller;

import com.ayata.ayatamart.dto.response.CartResponse;
import com.ayata.ayatamart.dto.response.UserRoleResponse;
import com.ayata.ayatamart.service.CartService;
import com.ayata.ayatamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
@RequestMapping("/ayatamart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;


    @GetMapping("/cart/products")
    public ResponseEntity<CartResponse> listCart(@RequestHeader("token") String token) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);

        if (userRoleResponse == null||userRoleResponse.getRole().equals("admin")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        CartResponse cartResponse = cartService.listCart(userRoleResponse.getEmployeeId());
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    @DeleteMapping("/cart/products")
    public ResponseEntity<Void> emptyCart(@RequestHeader("token") String token) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("admin")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        cartService.removeFromCart(userRoleResponse.getEmployeeId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/cart/orders")
    public ResponseEntity<Void> confirmOrder(@RequestHeader("token") String token) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("admin")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        cartService.confirmOrder(userRoleResponse.getEmployeeId());
        cartService.removeFromCart(userRoleResponse.getEmployeeId());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


}