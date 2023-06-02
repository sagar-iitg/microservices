package com.sk.user.service;

import com.sk.user.service.entities.Rating;
import com.sk.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating(){
//		Rating rating=Rating.builder().rating(10).userId("").hotelId(" ").feedback("this is created feign client").build();
//
//		ResponseEntity<Rating> responseEntity = ratingService.createRating(rating);
//
//		System.out.println("new Rating Created");
//
//	}

}
