package com.hm.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.dto.HotelDTO;
import com.hm.entity.Hotel;
import com.hm.repository.HotelRepository;


@Component
public class HotelConverter {
	
	@Autowired
	 HotelRepository hotelRepo;
	
	public Hotel convertHlDtoToEntity(HotelDTO hDto) {
		Hotel h=new Hotel();
		if(hDto!=null) {
			BeanUtils.copyProperties(hDto, h);
		}
		return h;
		
	}
//	method to convert hotel entity to  dto
	public HotelDTO convertHlEntityToDto(Hotel h) {
		HotelDTO hDto=new HotelDTO();
		if(h!=null) {
			BeanUtils.copyProperties(h, hDto);
		}
		return hDto;
	}
	

}
