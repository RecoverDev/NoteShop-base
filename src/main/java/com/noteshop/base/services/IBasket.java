package com.noteshop.base.services;

import com.noteshop.base.models.Basket;

import java.util.List;

public interface IBasket {

    /**
     * получить корзину пользователя
     */
    List<Basket> getBasket(Integer id_user);

    /**
     * добавить товар в корзину
     */
    boolean addToBasket(Basket basket);

    /**
     * удаление товара из корзины
     */
    void removeBasket(Basket basket);

    /**
     * очистить корзину пользователя
     */
    void eraseBasket(Integer id_user);
}
