package com.noteshop.base.services;

import java.util.List;

import com.noteshop.base.models.Order;

public interface IOrder {

    /**
     * возвращает список всех заказов
     * @return
     */
    List<Order> getOrders();

    /**
     * возвращает заказы по имени пользователя
     */
    List<Order> getOrdersByName(String name);

    /**
     * возвращает заказы по ID пользователя
     */
    List<Order> getOrdersByUser(Integer id_user);

    /**
     * добавляет новый заказ
     */
    boolean saveOrder(Order order);

    /**
     * удаляем заказ по id
     * @param id - ID заказа
     */
    boolean deleteOrderById(Integer id);
    
}
