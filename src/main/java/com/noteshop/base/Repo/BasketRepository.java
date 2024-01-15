package com.noteshop.base.Repo;

import com.noteshop.base.models.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasketRepository extends CrudRepository<Basket, Integer> {
}
