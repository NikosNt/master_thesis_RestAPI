package com.master.messages;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(	name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    private Long userId;
    private Integer sender;
    private String username_sender;
    private String title;
    private String message;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_time;

    public Messages() { }

    public Messages(Long businessId, Long userId, Integer sender,String username_receiver, String title, String message, Date date_time) {
        this.businessId = businessId;
        this.userId = userId;
        this.sender = sender;
        this.username_sender = username_sender;
        this.title = title;
        this.message = message;
        this.date_time = date_time;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBusinessId() { return businessId; }
    public void setBusinessId(Long businessId) { this.businessId = businessId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Integer getSender() { return sender; }
    public void setSender(Integer sender) { this.sender = sender; }

    public String getUsername_sender() { return username_sender; }
    public void setUsername_sender(String username_sender) { this.username_sender = username_sender; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Date getDate_time() { return date_time; }
    public void setDate_time(Date date_time) { this.date_time = date_time; }
}
