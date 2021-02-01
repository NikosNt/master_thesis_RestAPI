package com.master.business_rating;


import com.master.business.models.Business;
import com.master.business.repository.BusinessRepository;
import com.master.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    BusinessService businessService;

    /*
        Find By BusinessId
    */
    public List<Rating> listAllRatingsByBusinessId(Long businessId){
        List<Rating> ratings = ratingRepository.findByBusinessId(businessId);
        return ratings;
    }

    /*
        Find By UserId
    */
    public List<Rating> listAllRatingsByUserId(Long userId){
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        return ratings;
    }

    /*
    Find By UserId and businessId
*/
    public Rating listAllRatingsByUserIdAndBusinessId(Long businessId,Long userId){
        Rating ratings = ratingRepository.findByBusinessIdAndUserId(businessId,userId);
        return ratings;
    }

    /*
        Add a rating
    */
    public Rating saveRating(Rating rating){
        Rating newRating = ratingRepository.save(rating);
        return newRating;
    }

    /*
        Update a Rating(Den xreiazetai)
    */
    public Rating getRating(Long id){
        return ratingRepository.findById(id).get();
    }

    /*
        Remove a Rating
    */
    public void removeRating(Long id){
        ratingRepository.deleteById(id);
    }

    /*
        Update value of rating in business
    */
    public void updateValueOfRatingBusiness(Long business_id){
        List<Rating> ratings = ratingRepository.findByBusinessId(business_id);
        Float sum = 0.0f;

        for(Rating rat : ratings){
            sum=sum+rat.getRating();
        }

        Business business = businessRepository.findById(business_id).get();

        System.out.println(" Old "+ business.getRating());
        business.setRating(sum/ratings.size());
        businessService.updateSaveBusiness(business);
        System.out.println(" New "+ business.getRating());

    }
}
