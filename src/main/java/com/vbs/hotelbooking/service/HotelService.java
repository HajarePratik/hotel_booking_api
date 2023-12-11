package com.vbs.hotelbooking.service;

import com.vbs.hotelbooking.entity.Hotel;
import com.vbs.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public String addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
        return "Hotel Add Successfully";
    }

    public String updateHotel(int hotelId, Hotel hotel) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if (hotelOptional.isPresent()) {
            Hotel existingHotel = hotelOptional.get();
            existingHotel.setHotelName(hotel.getHotelName());
            existingHotel.setHotelAddress(hotel.getHotelAddress());
            existingHotel.setHotelNumber(hotel.getHotelNumber());
            hotelRepository.save(existingHotel);
            return "Hotel Updated Successfully";

        } else {
            return "Hotel Not Exist";
        }
    }

    public String deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
        return "Hotel Delete Successfully";
    }
}
