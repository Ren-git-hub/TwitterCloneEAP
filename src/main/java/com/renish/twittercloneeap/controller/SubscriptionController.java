package com.renish.twittercloneeap.controller;

import com.renish.twittercloneeap.model.Users;
import com.renish.twittercloneeap.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/subscriberList/{producerId}")
    public ResponseEntity<List<Users>> getSubscribersList(@PathVariable int producerId ) {
        return ResponseEntity.ok(subscriptionService.getSubscribersByProducer(producerId));
    }

}
