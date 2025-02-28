package com.renish.twittercloneeap.service;

import com.renish.twittercloneeap.model.Users;
import com.renish.twittercloneeap.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepo subscriptionRepo;

    public List<Users> getSubscribersByProducer(int producerId) {
        return subscriptionRepo.findSubscribersByProducer(producerId);
    }
}
