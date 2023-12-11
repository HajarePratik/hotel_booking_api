package com.vbs.hotelbooking.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private int hotelId;

    private String hotelName;

    private String hotelAddress;

    private String hotelNumber;

}
