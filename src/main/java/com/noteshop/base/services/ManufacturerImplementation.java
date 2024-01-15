package com.noteshop.base.services;

import com.noteshop.base.models.Manufacturer;
import com.noteshop.base.Repo.ManufacturerRepository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ManufacturerImplementation implements  IManufacturer{
    private ManufacturerRepository manufacturerRepository;

    public ManufacturerImplementation(ManufacturerRepository manufacturerRepository){
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public ArrayList<Manufacturer> getManufacturers() {
        return (ArrayList<Manufacturer>) manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getManufacturer(Integer id) {
        if(id == null){
            return null;
        }
        return manufacturerRepository.findById(id).get();
    }

    @Override
    public boolean addManufacturer(Manufacturer manufacturer) {
        if(manufacturer == null){
            return false;
        }
        Manufacturer result =  manufacturerRepository.save(manufacturer);
        return result != null;
    }

    @Override
    public void removeManufacturer(Manufacturer manufacturer) {
        if(manufacturer != null){
            manufacturerRepository.delete(manufacturer);
        }
    }
}
