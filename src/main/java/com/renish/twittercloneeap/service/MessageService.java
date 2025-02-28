package com.renish.twittercloneeap.service;

import com.renish.twittercloneeap.model.Messages;
import com.renish.twittercloneeap.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public List<Messages> getAllMessages() {
        return messageRepo.findAll();
    }

    public List<Messages> getAllMessagesById(int producerId) {
        return messageRepo.findAllById(Collections.singleton(producerId));
    }

    public List<Messages> getAllMessagesBySubscriberId(int subscriberId) {
        return messageRepo.findMessagesBySubscriber(subscriberId);
    }
}
