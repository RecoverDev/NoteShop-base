package com.noteshop.base.Repo;

import com.noteshop.base.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UsersRepository extends CrudRepository<User, Integer>{
    List<User> findByLoginAndPassword(String login, String pass);
}
