package com.master.messages;

import com.master.messages.Messages;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface MessageRepository extends  JpaRepository<Messages,Long> {

    List<Messages> findByUserIdAndBusinessId(Long userId,Long businessId);
    List<Messages> findByBusinessId(Long businessId);
}
