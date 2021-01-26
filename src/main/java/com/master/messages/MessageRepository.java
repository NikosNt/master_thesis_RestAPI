package com.master.messages;

import com.master.messages.Messages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface MessageRepository extends  JpaRepository<Messages,Long> {

    List<Messages> findByUserIdAndBusinessId(Long userId,Long businessId);
    List<Messages> findByBusinessId(Long businessId);

    //SELECT distinct sender,business_id,user_id FROM master_thesis.messages where business_id=13 and sender=1;
    @Query(value="SELECT  distinct  m.user_id FROM messages m where m.business_id=?1 and sender=1",nativeQuery = true)
    List<Messages> findByBusinessIdQuery(Long businessId);
}
