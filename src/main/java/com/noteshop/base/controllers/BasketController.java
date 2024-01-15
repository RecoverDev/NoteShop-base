package com.noteshop.base.controllers;

import com.noteshop.base.models.Basket;
import com.noteshop.base.services.BasketImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base")
public class BasketController {
    private BasketImplementation basketImplementation;

    public BasketController(BasketImplementation basketImplementation){
        this.basketImplementation = basketImplementation;
    }

    @GetMapping(value = "/basket/{id}")
    public ResponseEntity<List<Basket>> getBasket(@PathVariable(name = "id") Integer id_user){
        List<Basket> result = basketImplementation.getBasket(id_user);
        return result != null && !result.isEmpty() ? new ResponseEntity<>(result,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/addproduct")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody Basket basket){
        return basketImplementation.addToBasket(basket) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/removeproduct")
    public ResponseEntity<HttpStatus> removeProduct(@RequestBody Basket basket){
        basketImplementation.removeBasket(basket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/erasebasket/{id}")
    public ResponseEntity<HttpStatus> eraseBasket(@PathVariable(name = "id") Integer id_user){
        basketImplementation.eraseBasket(id_user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
