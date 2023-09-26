package com.hm.service;

import java.util.List;

import com.hm.dto.HotelDTO;
import com.hm.entity.Hotel;
import com.hm.exception.ResourceNotFoundException;


public interface HotelService {
	
	public HotelDTO createHotel(Hotel h);
	
	List<HotelDTO>getAllHotel();

	HotelDTO getHotelById(int id) throws ResourceNotFoundException ;
	
//	method to update
	HotelDTO updateHotelDetail(int hId,Hotel h) throws ResourceNotFoundException;
	
//	method to delete
	void deleteHotelById(int id);
	
	void hotelAssignedToBooking(int hId,int bId);
	

	//method to fetch student details using hotel location
	List<HotelDTO> getHotelByLocation(String location);
}
