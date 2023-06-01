package com.sk.user.service.services.impl;

import com.sk.user.service.entities.Hotel;
import com.sk.user.service.entities.Rating;
import com.sk.user.service.entities.User;
import com.sk.user.service.exception.ResourceNotFoundException;
import com.sk.user.service.repositories.UserRepository;
import com.sk.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;

  private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {


         String randomId=UUID.randomUUID().toString();
         user.setUserId(randomId);
            return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user doesn't exist with this is id --  "+userId));
        //fetch rating of the above from RATING SERVICE
        //coupling b/w userService and RatingService
        //http://localhost:8083/ratings/users/706a1033-5ff4-4977-be75-b23d696cd2c8


        //replaces host and port with service name
        //http://localhost:8083/ratings/users/
        Rating[] ratingsofUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info(ratingsofUser+" ");


        List<Rating> ratings=Arrays.stream(ratingsofUser).toList();


        List<Rating> ratingList=ratings.stream().map(rating -> {

            //api call to hotel Services

            //http://localhost:8082/hotels/69d70a96-7d7a-4478-8e6f-083b2e1fe2de
            ResponseEntity<Hotel>  forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=forEntity.getBody();

            logger.info("response status "+forEntity.getStatusCode());
            //set hotel to rating
            rating.setHotel(hotel);
            return  rating;

        }).collect(Collectors.toList());
        user.setRatings(ratingList);

        return  user;

    }
}
