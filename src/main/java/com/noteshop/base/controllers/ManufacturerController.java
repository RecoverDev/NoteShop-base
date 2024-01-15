package com.noteshop.base.controllers;

import com.noteshop.base.models.Manufacturer;
import com.noteshop.base.services.ManufacturerImplementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/base")
public class ManufacturerController {
    private ManufacturerImplementation manufacturerImplementation;

    public ManufacturerController(ManufacturerImplementation manufacturerImplementation){
        this.manufacturerImplementation = manufacturerImplementation;
    }

    @GetMapping(value = "/getproducers")
    public ResponseEntity<ArrayList<Manufacturer>> getManufacturers(){
        return new ResponseEntity<>(manufacturerImplementation.getManufacturers(), HttpStatus.OK);
    }

    @GetMapping(value = "/getproducer/{id}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable(name = "id") int id){
        Manufacturer result = manufacturerImplementation.getManufacturer(id);
        return result != null  ? new ResponseEntity<>(result,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/addproducer")
    public ResponseEntity<HttpStatus> addManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerImplementation.addManufacturer(manufacturer) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/removeproducer")
    public ResponseEntity<HttpStatus> removeManufacturer(@RequestBody Manufacturer manufacturer){
        manufacturerImplementation.removeManufacturer(manufacturer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
