package fr.soat.controller;

import fr.soat.model.User;
import fr.soat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mccstan on 19/11/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    //Create a Users
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  void create(@RequestBody User user){
        userRepository.save(user);
    }


    // Get User by id
    @RequestMapping(method = RequestMethod.GET)
    public List<User> readAll(){
        return userRepository.findAll();
    }

    // Get User by id
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User read(@PathVariable String id){
        return userRepository.findOne(id);
    }

    // Get User by name
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public User readByName(@RequestParam String name){
        return userRepository.findOneByName(name);
    }

    // Update a user
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  void update(@RequestBody User user){
        userRepository.save(user);
    }

    // Delete by id
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable String id){
        userRepository.delete(id);
    }


}
