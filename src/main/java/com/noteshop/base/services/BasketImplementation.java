package com.noteshop.base.services;

import com.noteshop.base.models.Basket;
import com.noteshop.base.Repo.BasketRepository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketImplementation  implements   IBasket{

    private BasketRepository baskets;

    public BasketImplementation(BasketRepository baskets){
        this.baskets = baskets;
    }
    @Override
    public List<Basket> getBasket(Integer id_user){
        ArrayList<Basket> result = (ArrayList<Basket>)baskets.findAll();
        return  result.stream().filter(b -> b.getId_user() == id_user).toList();
        //return (ArrayList<Basket>) ((ArrayList<Basket>)baskets.findAll()).stream().filter(b -> b.getId_user() == id_user);
    }

    @Override
    public boolean addToBasket(Basket basket){
        if(basket == null){
            return false;
        }
        Basket result = baskets.save(basket);
        return result != null;
    }

    @Override
    public void removeBasket(Basket basket){
        if(basket != null){
            baskets.delete(basket);
        }
    }

    @Override
    public void eraseBasket(Integer id_user){
        Iterable<Basket> basketUser = getBasket(id_user);
        if(basketUser != null){
            baskets.deleteAll(basketUser);
        }
    }
}
