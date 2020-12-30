package com.master.business_schedule.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(	name = "schedule_hours")
public class ScheduleHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String opening;
    private String closing;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false)
    @JsonIgnoreProperties("hours")
    private Business_schedule scheduleHours;

    public ScheduleHours() { }

    public ScheduleHours(Long id, String opening, String closing) {
        this.id = id;
        this.opening = opening;
        this.closing = closing;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOpening() { return opening; }
    public void setOpening(String opening) { this.opening = opening; }

    public String getClosing() { return closing; }
    public void setClosing(String closing) { this.closing = closing; }

    public Business_schedule getScheduleHours() { return scheduleHours; }
    public void setScheduleHours(Business_schedule schedule_hours) { this.scheduleHours = schedule_hours; }
}
