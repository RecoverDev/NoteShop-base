package com.noteshop.base.controllers;

import com.noteshop.base.models.User;
import com.noteshop.base.services.UsersImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/base")
public class UserController {
    private final UsersImplementation  users;
    
    public UserController(UsersImplementation users){
        this.users = users;
    }

    @GetMapping(value = "/getusers")
    public ResponseEntity<ArrayList<User>> getUsers(){
        ArrayList<User> result = users.getListUsers();
        return result != null && !result.isEmpty() ?
                new ResponseEntity<>(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user){
        return users.create(user) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<User> getuser(@PathVariable(name="id") int id){
        User user =  users.getUserById(id);
        return user == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/removeuser")
    public ResponseEntity<HttpStatus> removeuser(@RequestBody User user){
        ArrayList<User> listUsers = users.getListUsers();
        if(listUsers.stream().filter(u -> u.getId() == user.getId()).count() > 0) {
            users.removeUser(user);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/present/{log}/{pass}")
    public ResponseEntity<HttpStatus> isPresent(@PathVariable(name = "log") String log, @PathVariable(name = "pass") String pass){
        return users.testUser(log,pass) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
