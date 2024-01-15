package com.noteshop.base.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.noteshop.base.Repo.OrderRepository;
import com.noteshop.base.models.Order;

@Component
public class OrderImplementation implements IOrder{
    private OrderRepository orders;

    public OrderImplementation(OrderRepository ordersRepository){
        this.orders = ordersRepository;
    }

    @Override
    public List<Order> getOrders() {
        return (List<Order>)orders.findAll();
    }

    @Override
    public List<Order> getOrdersByName(String name) {
        return (List<Order>) orders.findByDeliveryName(name);
    }

    @Override
    public List<Order> getOrdersByUser(Integer id_user) {
        return orders.findByCustomer(id_user);
    }

    @Override
    public boolean saveOrder(Order order) {
        if(order == null){
            return false;
        }
        return orders.save(order) != null;
    }

    @Override
    public boolean deleteOrderById(Integer id){
        if(id == null){
            return false;
        }
        Order order = orders.findById(id).get();
        if(order == null){
            return false;
        }
        orders.delete(order);
        return true;
    }
    
}
