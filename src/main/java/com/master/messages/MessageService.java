package com.master.messages;

import com.master.messages.Messages;
import com.master.messages.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /*
    find messages between user and business
    */
    public List<Messages> listMessagesUserBusiness(Long userId, Long businessId){
        List<Messages> messages = messageRepository.findByUserIdAndBusinessId(userId,businessId);
        return messages;
    }

    /*
    find messages for business
    */
    public List<Messages> listMessagesBusiness( Long businessId){
        List<Messages> response_messages = messageRepository.findByBusinessId(businessId);
        List<Messages> messages_users = new ArrayList<>();
//        List <String> usernames= new ArrayList<>();
//        List<Messages> final_users = messageRepository.findByBusinessIdQuery(businessId);

        for(Messages m : response_messages){
            if(m.getSender() == 1){
                messages_users.add(m);
            }
        }
//        for(Messages m :final_users){
//            System.out.println(m.getUserId()+" - "+m.getBusinessId());
//        }



//        Integer count = 0;
//        for (Messages m : messages_users){
//            if(count == 0){
//                System.out.println("01 - mphka sthn count if");
//                count++;
//                usernames.add(m.getUsername_sender());
//                final_users.add(m);
//            }
////            for (Iterator<String> iterator = usernames.iterator(); iterator.hasNext(); ) {
////                String value = iterator.next();
//
//            for(Iterator<String> iterator = usernames.iterator(); iterator.hasNext();){
//                String value = iterator.next();
//                System.out.println(m.getUsername_sender()+" - "+value);
//
//                if(!m.getUsername_sender().equals(value)){
//                   // iterator.remove();
//                    usernames.add(m.getUsername_sender());
//                    final_users.add(m);
//                }
//
//                System.out.println("02 - else if statement mesa for");
//            }
//            System.out.println("03 - Bghka apo th mesa for");
//        }
//
//        System.out.println("04 - Bghka apo th eksw for");



        return messages_users;
    }

    //-------------------------------- Spare Code until plays--------------------------------------

    //                if(m.getUsername_sender().equals(user)){
    //                    System.out.println("if");
    //                    count++;
    //                }else{
    //                    System.out.println("else");
    //                    usernames.add(m.getUsername_sender());
    //                    final_users.add(m);
    //                }

    //        for(Messages m :final_users){
    //            System.out.println(m.getUsername_sender()+" - "+m.getTitle()+" - "+m.getId() );
    //        }
    //        for(String user:usernames){
    //            System.out.println(user);
    //        }


    //-----------------------------------------------------------------------------------------------

    /*
    add a new message
    */
    public Messages saveMessage(Messages message){
        if(message.getBusinessId() == null && message.getUserId() == null){
            return null;
        }else{
            Messages savedMessage = messageRepository.save(message);
            return savedMessage;
        }
    }
}


