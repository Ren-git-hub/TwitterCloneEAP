package com.renish.twittercloneeap.service;

import com.renish.twittercloneeap.model.Users;
import com.renish.twittercloneeap.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public List<Users> getAllProducers(){
        return userRepo.findUsersByIs_producer(true);
    }

    public List<Users> getAllSubscribers() {
        return userRepo.findUsersByIs_subscriber(true);
    }
}
