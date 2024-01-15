package com.noteshop.base.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.noteshop.base.models.Order;
import com.noteshop.base.services.OrderImplementation;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/base")
public class OrderController {
    private OrderImplementation orders;

    public OrderController(OrderImplementation orderImplementation){
        this.orders = orderImplementation;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orders.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/nameorders/{name}")
    public ResponseEntity<List<Order>> getOrderByName(@PathVariable(name = "name") String name) {
        List<Order> result = orders.getOrdersByName(name);
        return result.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(result,HttpStatus.OK);
    }
    
    @GetMapping("/userorders/{id}")
    public ResponseEntity<List<Order>> getOrderByUser(@PathVariable(name = "id") Integer id) {
        List<Order> result = orders.getOrdersByUser(id);
        return result.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/createorder")
    public ResponseEntity<HttpStatus> postCreateOrder(@RequestBody Order order) {
        return orders.saveOrder(order) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/deleteorder/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable(name = "id") Integer id) {
        orders.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
    
}
