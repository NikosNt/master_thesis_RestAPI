package com.master.business_rating;

import javax.persistence.*;

@Entity
@Table(	name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    private Long userId;
    private Float rating;

    public Rating() { }

    public Rating(Long id, Long businessId, Long userId, Float rating) {
        this.id = id;
        this.businessId = businessId;
        this.userId = userId;
        this.rating = rating;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBusinessId() { return businessId; }
    public void setBusinessId(Long businessId) { this.businessId = businessId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Float getRating() { return rating; }
    public void setRating(Float rating) { this.rating = rating; }
}
