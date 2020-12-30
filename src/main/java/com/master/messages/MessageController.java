package com.master.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    // view messages between user and a business
    @GetMapping("/view/{userId}/{businessId}")
    public ResponseEntity<?> listMessages(@PathVariable Long userId,@PathVariable Long businessId){
        List<Messages> messages = messageService.listMessagesUserBusiness(userId,businessId);
        if( messages.isEmpty()){
            return new ResponseEntity<>("No messages found !", HttpStatus.OK);
        }
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }

    // add a new message
    @PostMapping("/add")
    public ResponseEntity<?> createMessage(@RequestBody Messages message){
        Messages newMessage = messageService.saveMessage(message);
        if( isNull(newMessage)){
            return new ResponseEntity<>("Error something went wrong :( ", HttpStatus.OK);
        }
        return new ResponseEntity<>(newMessage,HttpStatus.OK);
    }



    // delete a message (isws kai oxi)
}
