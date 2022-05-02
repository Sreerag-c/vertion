
package com.ayata.ayatamart.controller;

import com.ayata.ayatamart.dto.request.StockRequest;
import com.ayata.ayatamart.dto.response.UserRoleResponse;
import com.ayata.ayatamart.exception.InvalidUserException;
import com.ayata.ayatamart.service.StockService;
import com.ayata.ayatamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ayatamart")
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private UserService userService;



    @PutMapping("/products/stock")
    public ResponseEntity<Void>updateStock(@RequestHeader("token") String token,@RequestBody StockRequest stockRequest){
        UserRoleResponse userRoleResponse = new UserRoleResponse();
        userRoleResponse = userService.isValidUser(token);
        if (userRoleResponse == null||userRoleResponse.getRole().equals("employee")) {
            throw new InvalidUserException(userRoleResponse.getEmployeeId());
        }

        stockService.updateStock(stockRequest);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }
}

