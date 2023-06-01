package com.sk.hotel.services;

import com.sk.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {



    //create


    Hotel create(Hotel hotel);
    //get all
    List<Hotel> getAll();


    //single
    Hotel get(String id);




}
