package com.renish.twittercloneeap.controller;

import com.renish.twittercloneeap.model.Messages;
import com.renish.twittercloneeap.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/messageList")
    public ResponseEntity<?> getMessageList(){
        return new ResponseEntity<List<Messages>>(messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/{producerId}")
    public ResponseEntity<List<Messages>> getMessageListByProducerId(@PathVariable("producerId") int producerId){
        return ResponseEntity.ok(messageService.getAllMessagesById(producerId));
    }

    @GetMapping("subscriber/{subscriberId}")
    public ResponseEntity<List<Messages>> getMessageListBySubscriberId(@PathVariable("subscriberId") int subscriberId){
        return ResponseEntity.ok(messageService.getAllMessagesBySubscriberId(subscriberId));
    }
}
