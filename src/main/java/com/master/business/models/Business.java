package com.master.business.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(	name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long moderatorId;
    private String type;
    private String business_name;
    private Float rating;
    private String info;
    private String ref;

    @OneToMany(mappedBy = "business_phones",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("business")
    private Set<Business_phones>  phones = new HashSet<>();

    @OneToMany(mappedBy = "business_owner",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("business")
    private Set<Business_owner>  owner = new HashSet<>();

    @OneToMany(mappedBy = "business_address",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("business")
    private Set<Business_address>  address = new HashSet<>();

    public Business() {
    }

    public Business(Long moderatorId, String type, String business_name, Float rating, String info, String ref) {
        this.moderatorId=moderatorId;
        this.type = type;
        this.business_name = business_name;
        this.rating = rating;
        this.info = info;
        this.ref = ref;
    }

    public Business(Long moderatorId, String type, String business_name, Float rating, String info, String ref, Set<Business_phones> phones, Set<Business_owner> owner, Set<Business_address> address) {
        this.moderatorId = moderatorId;
        this.type = type;
        this.business_name = business_name;
        this.rating = rating;
        this.info = info;
        this.ref = ref;
        this.phones = phones;
        this.owner = owner;
        this.address = address;
    }

    public Long getModeratorId() { return moderatorId; }
    public void setModeratorId(Long moderatorId) { this.moderatorId = moderatorId; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

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

        for(Business_phones p : phones){
            p.setBusiness(this);
        }
    }

    public Set<Business_owner> getOwner() { return owner; }
    public void setOwner(Set<Business_owner> owner) {
        this.owner = owner;

        for(Business_owner o : owner){
            o.setBusiness(this);
        }
    }

    public Set<Business_address> getAddress() { return address; }
    public void setAddress(Set<Business_address> address) {
        this.address = address;

        for(Business_address a : address){
            a.setBusiness(this);
        }
    }
}
