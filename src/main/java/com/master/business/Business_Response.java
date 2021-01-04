package com.master.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.master.business.models.Business_address;
import com.master.business.models.Business_owner;
import com.master.business.models.Business_phones;
import com.master.business.models.Business_type;
import com.master.business_schedule.models.ScheduleHours;

import java.util.HashSet;
import java.util.Set;

public class Business_Response {


    private Long business_id;
    private Long moderatorId;
    private String business_name;
    private Float rating;
    private String info;
    private String ref;
    @JsonIgnoreProperties("business_owner")
    private Set<Business_owner> owner = new HashSet<>();
    @JsonIgnoreProperties("business_type")
    private  Set<Business_type>  b_type = new HashSet<>();
    @JsonIgnoreProperties("business_address")
    private  Set<Business_address>  address = new HashSet<>();
    @JsonIgnoreProperties("business_phones")
    private  Set<Business_phones>  phones = new HashSet<>();
    private Integer day;
    private Integer state;
    @JsonIgnoreProperties("scheduleHours")
    private Set<ScheduleHours> hours = new HashSet<>();

    public Business_Response() {
    }

    public Business_Response(Long business_id, Long moderatorId, String business_name, Float rating, String info, String ref, Set<Business_owner> owner, Set<Business_type> b_type, Set<Business_address> address, Set<Business_phones> phones, Integer day, Integer state, Set<ScheduleHours> hours) {
        this.business_id = business_id;
        this.moderatorId = moderatorId;
        this.business_name = business_name;
        this.rating = rating;
        this.info = info;
        this.ref = ref;
        this.owner = owner;
        this.b_type = b_type;
        this.address = address;
        this.phones = phones;
        this.day = day;
        this.state = state;
        this.hours = hours;
    }

    public Long getBusiness_id() {return business_id; }
    public void setBusiness_id(Long business_id) {this.business_id = business_id; }

    public Long getModeratorId() { return moderatorId; }
    public void setModeratorId(Long moderatorId) { this.moderatorId = moderatorId; }


    public String getBusiness_name() { return business_name; }
    public void setBusiness_name(String business_name) { this.business_name = business_name; }

    public Float getRating() { return rating; }
    public void setRating(Float rating) { this.rating = rating; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }

    public Set<Business_phones> getPhones() {
        return phones;
    }
    public void setPhones(Set<Business_phones> phones) {
        this.phones = phones;

//        for(Business_phones p : phones){
//            p.setBusiness_phones(this);
//        }
    }

    public Set<Business_owner> getOwner() { return owner; }
    public void setOwner(Set<Business_owner> owner) {
        this.owner = owner;

//        for(Business_owner o : owner){
//            o.setBusiness_owner(this);
//        }
    }

    public Set<Business_address> getAddress() { return address; }
    public void setAddress(Set<Business_address> address) {
        this.address = address;

//        for(Business_address a : address){
//            a.setBusiness_address(this);
//        }
    }

    public Set<Business_type> getB_type() { return b_type; }

    public void setB_type(Set<Business_type> b_type) {
        this.b_type = b_type;
//        for(Business_type t : b_type){
//            t.setBusiness_type(this);
//        }
    }

    public Integer getDay() { return day; }
    public void setDay(Integer day) { this.day = day; }

    public Integer getState() { return state; }
    public void setState(Integer state) { this.state = state; }

    public Set<ScheduleHours> getHours() { return hours; }
    public void setHours(Set<ScheduleHours> hours) {
        this.hours = hours;
//        for(ScheduleHours h : hours){
//            h.setScheduleHours(this);
//        }
    }
}
