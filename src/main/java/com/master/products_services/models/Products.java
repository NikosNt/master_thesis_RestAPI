package com.master.products_services.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.master.business_schedule.models.ScheduleHours;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    private String name;
    private Integer number;
    private Float value;
    private String info;

    @OneToMany( mappedBy = "product",cascade = CascadeType.ALL )
    @JsonIgnoreProperties("product")
    private Set<Product_Photos> photos_path = new HashSet<>();

    public Products() {}

    public Products(Long businessId, String name, Integer number, Float value, String info) {
        this.businessId = businessId;
        this.name = name;
        this.number = number;
        this.value = value;
        this.info = info;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBusiness_id() { return businessId; }
    public void setBusiness_id(Long business_id) { this.businessId = business_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Float getValue() { return value; }
    public void setValue(Float value) { this.value = value; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public Set<Product_Photos> getPhotos_path() { return photos_path; }

    public void setPhotos_path(Set<Product_Photos> photos_path) {
        this.photos_path = photos_path;
        for(Product_Photos p : photos_path){
            p.setProduct(this);
        }
    }
}
