package com.sk.rating.services;

import com.sk.rating.entities.Rating;

import java.util.List;

public interface RatingService {


    //create

    Rating create(Rating rating);


    //get all
    List<Rating> getRatings();


    //get all by userId

    List<Rating> getRatingByUserId(String userId);

    //get all By Hotel


    List<Rating> getRatingByHotelId(String hotelId);




}
