package com.hm.serviceTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hm.entity.Hotel;
import com.hm.repository.HotelRepository;
import com.hm.service.HotelService;
import com.hm.utils.HotelConverter;

@SpringBootTest
public class HotelServiceTest {
	
	@Autowired
	HotelConverter hotelConverter;
	
	@Autowired
	HotelService hotelService;
	
	@MockBean
	HotelRepository hotelRepo;
	
	@Test
	@DisplayName("Hotel Name")
	void testMethodHotelName() {
		Hotel h=Hotel.builder().hotelName("Taj Hotel").location("Mumbai").rating(5).build();
		Mockito.when(hotelRepo.save(h)).thenReturn(h);
		assertTrue(hotelService.createHotel(h).getHotelName().equals("Taj Hotel"));
	}
	
	@Test
	@DisplayName("Location")
	void testMethodHotelLocation() {
			Hotel h=Hotel.builder().hotelName("The Leela Palace ").location("Delhi").rating(4).build();
			Mockito.when(hotelRepo.save(h)).thenReturn(h);
			assertTrue(hotelService.createHotel(h).getLocation().equals("Delhi"));
		}
	
	@Test
	@DisplayName("Negative Test Case")
	void negativeTestMethod() {
			Hotel h=Hotel.builder().hotelName("The Leela Palace ").location("Delhi").rating(4).build();
			Mockito.when(hotelRepo.save(h)).thenReturn(h);
			assertTrue(hotelService.createHotel(h).getLocation().equals("Kolkata"));
		}
	
	

}
