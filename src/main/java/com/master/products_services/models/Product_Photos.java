package com.master.products_services.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

@Entity
@Table(	name = "products_photos_path")
public class Product_Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties("photos_path")
    private Products product;

    public Product_Photos() { }

    public Product_Photos(String path, String description, Products product) {
        this.path = path;
        this.description = description;
        this.product = product;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Products getProduct() { return product; }
    public void setProduct(Products product) { this.product = product; }
}
