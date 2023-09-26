package com.hm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hm.dto.BookingDTO;
import com.hm.entity.Booking;
import com.hm.entity.RoomType;
import com.hm.repository.CustomerRepository;
import com.hm.service.BookingService;
import com.hm.service.RoomTypeService;
import com.hm.utils.BookingConverter;

@RestController
public class BookingController {

    @Autowired
    BookingConverter bookConverter;

    @Autowired
    BookingService bookService;
    
    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/saveBooking/{id}")
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bDto,@PathVariable("id") int customerId) {
        final Booking b = bookConverter.convertBkDtoToEntity(bDto);

       

        // Create the booking without passing the customer ID separately
        BookingDTO createdBookingDTO = bookService.createBooking(b, customerId);

        return new ResponseEntity<>(createdBookingDTO, HttpStatus.CREATED);
    }
    
	@GetMapping("/getAllBooking")
	public List<BookingDTO>getAllBookingr() {
		return bookService.getAllBookings();
	}
	
	@GetMapping("/getBookingById/{id}")
	 BookingDTO getBookingById(@PathVariable("id") int bId) {
		return bookService.getBookingById(bId);
	}
	
	@PutMapping("/updateBookingById/{bId}")
	BookingDTO updateBookingById(@PathVariable("bId") int id ,BookingDTO bDto) {
		final Booking c=bookConverter.convertBkDtoToEntity(bDto);
		return bookService.updateBooking(id, c);
	}
	
	@DeleteMapping("/deleteBookingById/{bId}")
	 public ResponseEntity<String> deleteBookingById(@PathVariable("bId") int id){
		bookService.deleteBooking(id);
		return new ResponseEntity<String> ("Booking with id"+id+" deleted success ", HttpStatus.OK );
	}
  
	
	


    
   }
