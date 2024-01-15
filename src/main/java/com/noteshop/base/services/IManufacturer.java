package com.noteshop.base.services;

import com.noteshop.base.models.Manufacturer;

import java.util.ArrayList;

public interface IManufacturer {

    /**
     * получить список производителей
     */
    ArrayList<Manufacturer> getManufacturers();

    /**
     * получить производителя по коду
     */
    Manufacturer getManufacturer(Integer id);

    /**
     * добавить производителя
     */
    boolean addManufacturer(Manufacturer manufacturer);

    /**
     * удалить производителя
     */
    void removeManufacturer(Manufacturer manufacturer);
}
