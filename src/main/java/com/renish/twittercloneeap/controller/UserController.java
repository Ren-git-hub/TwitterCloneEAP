package com.renish.twittercloneeap.controller;

import com.renish.twittercloneeap.model.Users;
import com.renish.twittercloneeap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/producers")
    public ResponseEntity<List<Users>> getAllUsersProducer(){
        return ResponseEntity.ok(userService.getAllProducers());
    }

    @GetMapping("/subscribers")
    public ResponseEntity<List<Users>> getAllUsersSubscriber(){
        return new ResponseEntity<>(userService.getAllSubscribers(),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user){
        return new ResponseEntity<>(userService.verifyUser(user),HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Users user){
        return new ResponseEntity<>(userService.signup(user),HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
