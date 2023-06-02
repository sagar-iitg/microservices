package com.sk.user.service.controller;


import com.sk.user.service.entities.User;
import com.sk.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {


    @Autowired
    private UserService userService;
    //create

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User>  createUser(@RequestBody User user)
    {
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);



    }

    //single user get

    int retryCount=1;

    @GetMapping("/{userId}")
    //@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
     //@RateLimiter(name="userRateLimiter",fallbackMethod ="ratingHotelFallback")
    public  ResponseEntity<User> getSingleUser(@PathVariable String userId){



        logger.info("Retry Count {}",retryCount);
        retryCount++;
                User user=userService.getUser(userId);
                return ResponseEntity.ok(user);

    }


    //creating fallback method for circuit breaker

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){


        User dummy = User.builder().email("dummy@gmail.com").name("Dummy").
                about("This user is created because some service is down").userId("1234").build();

        return new ResponseEntity<>(dummy,HttpStatus.OK);



    }


    //all user get


    @GetMapping
    public  ResponseEntity<List<User>> getSingleUser(){

        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);

    }

}
