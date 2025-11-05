package com.userbooking.user.booking.service;

import com.userbooking.user.booking.dao.BookingRepo;
import com.userbooking.user.booking.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    public String saveBooking(Booking booking){
        Booking b= bookingRepo.save(booking);
        if(b!=null){
            return "success";
        }
        return "error";
    }
    public List<Booking> getAllBookingByUserId(Long id){
      return   bookingRepo.findByUserInfo(id);
    }
    public void deleteBooking(Long id){{
        bookingRepo.delete(bookingRepo.findById(id).get());
    }}
}
