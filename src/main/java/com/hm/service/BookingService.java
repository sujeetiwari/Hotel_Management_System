package com.hm.service;

import com.hm.dto.BookingDTO;
import com.hm.entity.Booking;
import com.hm.entity.RoomType;
import com.hm.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

//	method to create Booking
    BookingDTO createBooking(Booking booking, int customerId);

//    method to get all booking
    List<BookingDTO> getAllBookings();
    
//    method to get Booking by id
    BookingDTO getBookingById(int bookingId) throws ResourceNotFoundException;
    
//    method to update booking by id
    BookingDTO updateBooking(int bookingId, Booking booking) throws ResourceNotFoundException;

//    method to delete booking by id
    void deleteBooking(int bookingId);
    
    


}
