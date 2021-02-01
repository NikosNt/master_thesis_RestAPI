package com.master.business_rating;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> findByBusinessId(Long businessId);
    List<Rating> findByUserId(Long userId);
    Rating findByBusinessIdAndUserId(Long businessId,Long userId);

}
