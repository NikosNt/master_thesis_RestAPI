package com.master.business.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "business_address")
public class Business_address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private Integer zip_code;
    private Integer street_number;
    private Float latitude;
    private Float longitude;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    @JsonIgnoreProperties("address")
    private Business business_address;

    public Business_address() {
    }

    public Business_address( String city, String street, Integer zip_code, Integer street_number, Float latitude, Float longitude) {
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
        this.street_number = street_number;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public Integer getZip_code() { return zip_code; }
    public void setZip_code(Integer zip_code) { this.zip_code = zip_code; }

    public Integer getStreet_number() { return street_number; }
    public void setStreet_number(Integer street_number) { this.street_number = street_number; }

    public Float getLatitude() { return latitude; }
    public void setLatitude(Float latitude) { this.latitude = latitude; }

    public Float getLongitude() { return longitude; }
    public void setLongitude(Float longitude) { this.longitude = longitude; }

    public Business getBusiness_address() { return business_address; }
    public void setBusiness_address(Business business_address) { this.business_address = business_address; }
}
