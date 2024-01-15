package com.noteshop.base.services;

import java.util.ArrayList;

import com.noteshop.base.models.Notebook;

public interface INotebook {
    
    /**
     * получения полного списка товаров
     */
    ArrayList<Notebook> getNotebooks();

    /**
     * добавление товара в базу
     */
    boolean addNotebook(Notebook notebook);

    /**
     * удаление товара из базы
     */
    void removeNotebook(Notebook notebook);

    /**
     * получение товара по ID
     */
    Notebook gNotebook(Integer id);
}
