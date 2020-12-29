package com.master.messages.services;

import com.master.messages.models.Messages;
import com.master.messages.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    //find messages between user and business
    public List<Messages> listMessagesUserBusiness(Long userId, Long businessId){
        List<Messages> messages = messageRepository.findByUserIdAndBusinessId(userId,businessId);
        return messages;
    }

    // add a new message
    public Messages saveMessage(Messages message){
        if(message.getBusinessId() == null && message.getUserId() == null){
            System.out.println("Mphka 1");
            return null;
        }else{
            Messages savedMessage = messageRepository.save(message);
            return savedMessage;
        }
    }
}


