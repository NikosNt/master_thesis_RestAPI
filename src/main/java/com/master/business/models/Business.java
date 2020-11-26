package com.master.business.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(	name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String business_name;
    private Float rating;
    private String info;
    private String ref;

    public Business() {
    }

    public Business(Long id, String type, String business_name, Float rating, String info, String ref) {
        this.id = id;
        this.type = type;
        this.business_name = business_name;
        this.rating = rating;
        this.info = info;
        this.ref = ref;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) { this.ref = ref; }
}
