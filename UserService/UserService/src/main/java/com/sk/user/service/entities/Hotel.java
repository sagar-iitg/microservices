package com.sk.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;

}
