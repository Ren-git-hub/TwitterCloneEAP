package com.renish.twittercloneeap.controller;

import com.renish.twittercloneeap.model.Users;
import com.renish.twittercloneeap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
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
}
