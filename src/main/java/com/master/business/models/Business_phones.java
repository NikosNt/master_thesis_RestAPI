package com.master.business.models;

import javax.persistence.*;

@Entity
@Table(name = "business_phones")
public class Business_phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long business_id;
    private String phone_number;

    public Business_phones() {
    }

    public Business_phones(Long business_id, String phone_number) {
        this.business_id = business_id;
        this.phone_number = phone_number;
    }

    public Long getBusiness_id() { return business_id; }
    public void setBusiness_id(Long business_id) { this.business_id = business_id; }

    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }
}
