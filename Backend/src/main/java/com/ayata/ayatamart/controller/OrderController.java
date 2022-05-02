package com.ayata.ayatamart.controller;

import com.ayata.ayatamart.dto.request.OrderStatusRequest;
import com.ayata.ayatamart.dto.response.OrderResponse;
import com.ayata.ayatamart.dto.response.UserRoleResponse;
import com.ayata.ayatamart.service.OrderService;
import com.ayata.ayatamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/ayatamart")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    @GetMapping("/orders")
    public ResponseEntity<OrderResponse> listOrders(@RequestHeader("token") String token) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        OrderResponse orderResponse = orderService.listOrders(userRoleResponse.getEmployeeId());
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PatchMapping("/orders")
    public ResponseEntity<Void> changeOrderStatus(@RequestHeader("token") String token, @RequestBody OrderStatusRequest orderStatusRequest) {
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("employee")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        OrderService service = orderService;
        service.updateOrderStatus(orderStatusRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


