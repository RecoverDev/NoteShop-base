package com.noteshop.base.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.noteshop.base.Repo.UsersRepository;
import com.noteshop.base.models.User;

import java.util.Optional;


@Component
public class UsersImplementation implements IUsers {
    private UsersRepository userRepository;

    public UsersImplementation(UsersRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean create(User user) {
        if(user == null){
            return false;
        }
        User result = userRepository.save(user);
        return result != null;
    }


    @Override
    public ArrayList<User> getListUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(int id){
        Optional<User> result =  userRepository.findById(id);
        return result.get();
    }

    @Override
    public void removeUser(User user){
        if(user != null){
            userRepository.delete(user);
        }
    }

    @Override
    public boolean testUser(String login, String pass){
        return getListUsers().stream().filter(u -> u.getLogin().equals(login) & u.getPassword().equals(pass)).count() > 0;
    }

}