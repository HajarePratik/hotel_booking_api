package com.vbs.hotelbooking.controller;

import com.vbs.hotelbooking.entity.Hotel;
import com.vbs.hotelbooking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels() {
        return hotelService.findAllHotels();
    }

    @PostMapping("/addHotel")
    public String addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/updateHotel/{hotelId}")
    public String updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/deleteHotel/{hotelId}")
    public String deleteHotel(@PathVariable int hotelId) {
        return hotelService.deleteHotel(hotelId);
    }
}
