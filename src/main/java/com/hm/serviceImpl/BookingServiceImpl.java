package com.hm.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.dto.BookingDTO;
import com.hm.entity.Booking;
import com.hm.entity.Customer;
import com.hm.entity.Room;
import com.hm.entity.RoomType;
import com.hm.exception.ResourceNotFoundException;
import com.hm.repository.BookingRepository;
import com.hm.repository.CustomerRepository;
import com.hm.repository.RoomRepository;
import com.hm.service.BookingService;
import com.hm.utils.BookingConverter;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
	
//	logger created
	private static final Logger log=LoggerFactory.getLogger(Booking.class);


	@Autowired
     BookingRepository bookingRepository;
	
	@Autowired
     BookingConverter bookingConverter;
	
	@Autowired
     CustomerRepository customerRepository;
	
	@Autowired
	RoomRepository roomRepository;

  

    @Override
    public BookingDTO createBooking(Booking booking, int customerId) {
    	
    	 // Retrieve the Customer entity by customer ID
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->
        new ResourceNotFoundException("Customer", "id", customerId));

        // Set the retrieved customer in the Booking entity
        booking.setCustomer(customer);
        booking.calculatePrice();
//        booking.generateRandomRoomId();
        
        Booking savedBooking = bookingRepository.save(booking);
		log.info("New Booking details " + booking.toString() + " saved at "+new Date());

        return bookingConverter.convertBkEntityToDto(savedBooking);
    }

	@Override
	public List<BookingDTO> getAllBookings() {
		List<Booking>b=bookingRepository.findAll();
		List<BookingDTO>bDto=new ArrayList<>();
		for(Booking book: b) {
			bDto.add(bookingConverter.convertBkEntityToDto(book));
		}
		log.info("All Booking details fetched at "+new Date());

		return bDto;
	}

	@Override
	public BookingDTO getBookingById(int bookingId) throws ResourceNotFoundException {
		Booking b=bookingRepository.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "id", bookingId));
		
		return bookingConverter.convertBkEntityToDto(b);
	}

	@Override
	public BookingDTO updateBooking(int bookingId, Booking booking) throws ResourceNotFoundException {
		Booking b=bookingRepository.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking", "id", bookingId));
		b.setCheckInDate(booking.getCheckInDate());
		b.setCheckOutDate(booking.getCheckOutDate());
		b.setRoomType(booking.getRoomType());
		bookingRepository.save(b);
		return bookingConverter.convertBkEntityToDto(booking);
	}

	@Override
	public void deleteBooking(int bookingId) {
		Booking b=bookingRepository.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Booking","id", bookingId));
		bookingRepository.deleteById(bookingId);
	}

	

	





	

}
