package fr.soat.controller;

import fr.soat.model.User;
import fr.soat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mccstan on 19/11/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    //Create a User
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  void create(@RequestBody User user){
        userRepository.save(user);
    }

    // Get User by id
    @RequestMapping(value = "/{id}")
    public User read(@PathVariable String id){
        return userRepository.findOne(id);
    }

    // Update a user
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  void update(@RequestBody User user){
        userRepository.save(user);
    }

    // Delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        userRepository.delete(id);
    }


}
