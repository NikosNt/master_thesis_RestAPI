package com.master.business.models;

import javax.persistence.*;

@Entity
@Table(name = "business_owner")
public class Business_owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long business_id;
    private String fname;
    private String lname;

    public Business_owner() {
    }

    public Business_owner(Long business_id, String fname, String lname) {
        this.business_id = business_id;
        this.fname = fname;
        this.lname = lname;
    }

    public Long getBusiness_id() { return business_id; }
    public void setBusiness_id(Long business_id) { this.business_id = business_id; }

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }
}
