package com.renish.twittercloneeap.service;

import com.renish.twittercloneeap.model.Users;
import com.renish.twittercloneeap.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    private JWTService jwtService;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public List<Users> getAllProducers(){
        return userRepo.findUsersByIs_producer(true);
    }

    public List<Users> getAllSubscribers() {
        return userRepo.findUsersByIs_subscriber(true);
    }

    public String verifyUser(Users user) {
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }

    public String signup(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "Sign up successful";
    }

    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "Delete successful";
    }
}
