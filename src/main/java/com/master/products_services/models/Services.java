package com.master.products_services.models;

import javax.persistence.*;

@Entity
@Table(	name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    private String name;
    private Float value;
    private String info;

    public Services() {}

    public Services(Long businessId, String name, Float value, String info) {
        this.businessId = businessId;
        this.name = name;
        this.value = value;
        this.info = info;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBusiness_id() { return businessId; }
    public void setBusiness_id(Long businessId) { this.businessId = businessId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getValue() { return value; }
    public void setValue(Float value) { this.value = value; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
}
