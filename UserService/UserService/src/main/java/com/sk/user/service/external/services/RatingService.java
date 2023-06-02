package com.sk.user.service.external.services;


import com.sk.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="RATING-SERVICE")
@Service
public interface RatingService {


    //POST


    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);




    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable  String ratingId, Rating rating);


    //delete

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);






}
