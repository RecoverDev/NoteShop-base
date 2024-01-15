package com.noteshop.base.services;

import java.util.ArrayList;

import com.noteshop.base.models.User;

public interface IUsers {
    
    /**
     * создаем нового пользователя
     */
    boolean create(User user);

    /**
     * Возвращает список пользователей
     */
    ArrayList<User> getListUsers();

    /**
     * Возвращает пользователя по ID
     */
    User getUserById(int id);

    /**
     * Удаляем пользователя
     */
    void removeUser(User user);

    /**
     * проверка наличия пользователя
     */
    boolean testUser(String login, String pass);
}
