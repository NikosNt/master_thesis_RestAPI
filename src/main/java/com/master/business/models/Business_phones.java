package com.master.business.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "business_phones")
public class Business_phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone_number;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    @JsonIgnoreProperties("phones")
    private Business business_phones;


    public Business_phones() { }
    public Business_phones(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Business getBusiness_phones() {
        return business_phones;
    }

    public void setBusiness_phones(Business business_phones) {
        this.business_phones = business_phones;
    }
}
