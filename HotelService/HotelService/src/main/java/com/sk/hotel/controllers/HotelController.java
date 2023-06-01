package com.sk.hotel.controllers;


import com.sk.hotel.entites.Hotel;
import com.sk.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    private HotelService hotelService;

    //create

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //get single api


    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));
    }







    //get all


    @GetMapping

    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        return  ResponseEntity.ok(hotelService.getAll());
    }

}
