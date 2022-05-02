package com.ayata.ayatamart.service.serviceimpl;

import com.ayata.ayatamart.dto.request.OrderStatusRequest;
import com.ayata.ayatamart.dto.response.OrderModelResponse;
import com.ayata.ayatamart.dto.response.OrderResponse;
import com.ayata.ayatamart.exception.OrderNotFoundException;
import com.ayata.ayatamart.exception.ResourceNotFoundException;
import com.ayata.ayatamart.model.Order;
import com.ayata.ayatamart.model.Product;
import com.ayata.ayatamart.model.User;
import com.ayata.ayatamart.model.UserRole;
import com.ayata.ayatamart.repository.OrderRepository;
import com.ayata.ayatamart.repository.ProductRepository;
import com.ayata.ayatamart.repository.UserRepository;
import com.ayata.ayatamart.repository.UserRoleRepository;
import com.ayata.ayatamart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public OrderResponse listOrders(Integer employeeId) {

        OrderResponse orderResponse = new OrderResponse();
        List<OrderModelResponse> orderModelResponseList = new ArrayList<>();

        Optional<UserRole> userRoleOptional = userRoleRepository.findByEmployeeId(employeeId);
        if (userRoleOptional.isPresent()) {

            UserRole userRole = userRoleOptional.get();
            if (userRole.getRoleId() == 1) {
                List<Order> orders = orderRepository.findAll();
                for (Order order : orders) {
                    OrderModelResponse orderModelResponse = new OrderModelResponse();
                    Optional<Product> optionalProducts = productRepository.findByProductId(order.getProductId());
                    Product product = optionalProducts.get();
                    orderModelResponse.setImage(product.getImage());
                    orderModelResponse.setProductName(product.getProductName());

                    Optional<User> optionalUser = userRepository.findByEmployeeId(order.getEmployeeId());
                    User user = optionalUser.get();
                    orderModelResponse.setEmployeeName(user.getEmployeeName());
                    orderModelResponse.setOrderId(order.getOrderId());
                    orderModelResponse.setProductId(order.getProductId());
                    orderModelResponse.setEmployeeId(order.getEmployeeId());
                    orderModelResponse.setStatus(order.getStatus());
                    orderModelResponse.setTotalAmount(order.getTotalAmt());
                    orderModelResponseList.add(orderModelResponse);

                    orderResponse.setOrderModelResponses(orderModelResponseList);
                }
            } else {
                List<Order> orders = orderRepository.findByEmployeeId(employeeId);
                for (Order order : orders) {
                    OrderModelResponse orderModelResponse = new OrderModelResponse();
                    Optional<Product> optionalProducts = productRepository.findByProductId(order.getProductId());
                    Product product = optionalProducts.get();
                    orderModelResponse.setImage(product.getImage());
                    orderModelResponse.setProductName(product.getProductName());
                    orderModelResponse.setOrderId(order.getOrderId());
                    orderModelResponse.setProductId(order.getProductId());
                    orderModelResponse.setEmployeeId(order.getEmployeeId());
                    orderModelResponse.setStatus(order.getStatus());
                    orderModelResponse.setTotalAmount(order.getTotalAmt());
                    orderModelResponseList.add(orderModelResponse);
                    orderResponse.setOrderModelResponses(orderModelResponseList);
                }
            }
        } else {
            throw new ResourceNotFoundException("Role not assigned");
        }

        return orderResponse;

    }

    @Override
    public void updateOrderStatus(OrderStatusRequest orderStatusRequest) {
        Optional<Order> orderOptional = orderRepository.findByOrderId(orderStatusRequest.getOrderId());
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(orderStatusRequest.getStatus());
            orderRepository.save(order);
        } else {
            throw new OrderNotFoundException("Order not found!");
        }
    }

}
