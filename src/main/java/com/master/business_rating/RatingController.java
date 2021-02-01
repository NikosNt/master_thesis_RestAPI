package com.master.business_rating;


import com.master.business.models.Business;
import com.master.business.repository.BusinessRepository;
import com.master.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static java.util.Objects.isNull;
@RestController
@CrossOrigin
@RequestMapping("/api/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    BusinessService businessService;


    /*
        View ratings of a business(Mporei na mhn xreiastei san end-point)
    */
    @GetMapping("/by/business/{businessId}")
    public ResponseEntity<?> listRatingsByBusinessId(@PathVariable Long businessId ) {
        List<Rating> ratings = ratingService.listAllRatingsByBusinessId(businessId);
        if(isNull(ratings)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }

    /*
        View Ratings of a user(Mporei na mhn xreiastei san end-point)
    */
    @GetMapping("/by/user/{userId}")
    public ResponseEntity<?> listRatingsByUserId(@PathVariable Long userId ) {
        List<Rating> ratings = ratingService.listAllRatingsByUserId(userId);
        if(isNull(ratings)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }

    /*
    View Ratings of a user for a business(Mporei na mhn xreiastei san end-point)
*/
    @GetMapping("/by/{businessId}/{userId}")
    public ResponseEntity<?> listRatingsByUserId(@PathVariable Long userId,@PathVariable Long businessId ) {
        Rating ratings = ratingService.listAllRatingsByUserIdAndBusinessId(businessId,userId);
        if(isNull(ratings)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }

    /*
        Add a rating
    */
    @PostMapping("/add")
    public ResponseEntity<?> listRatingsByUserId( @RequestBody Rating rating ) {
        Rating response = ratingService.saveRating(rating);
        ratingService.updateValueOfRatingBusiness(rating.getBusinessId());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /*
        Update a Rating
    */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRatingsById( @RequestBody Rating rating, @PathVariable Long id ) {
        rating.setId(id);
        Rating response = ratingService.saveRating(rating);
        ratingService.updateValueOfRatingBusiness(rating.getBusinessId());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    /*
        Remove a Rating
    */
    @DeleteMapping("/delete/{businessId}/{id}")
    public ResponseEntity<?> deleteRatingsById( @PathVariable Long businessId, @PathVariable Long id ) {
        try{
            ratingService.removeRating(id);
            ratingService.updateValueOfRatingBusiness(businessId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
        }

    }

}
