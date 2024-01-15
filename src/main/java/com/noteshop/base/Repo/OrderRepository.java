package com.noteshop.base.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noteshop.base.models.Order;
import java.util.List;


@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer>{

    List<Order> findByDeliveryName(String deliveryName);

    List<Order> findByCustomer(Integer id_user);
    
}
