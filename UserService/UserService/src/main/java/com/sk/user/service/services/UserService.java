package com.sk.user.service.services;

import com.sk.user.service.entities.User;

import java.util.List;

public interface UserService {



    //create

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);


    //To Do

    //delete
    //update





}
