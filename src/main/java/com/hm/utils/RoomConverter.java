package com.hm.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.dto.RoomDTO;
import com.hm.entity.Room;
import com.hm.repository.RoomRepository;

@Component
public class RoomConverter {

	@Autowired
	RoomRepository roomRepo;
	
	public Room convertRmDtoToEntity(RoomDTO rDto) {
		Room r=new Room();
		if(rDto!=null) {
			BeanUtils.copyProperties(rDto, r);
		}
		return r;
		
	}
//	method to convert Room entity to  dto
	public RoomDTO convertRmEntityToDto(Room r) {
		RoomDTO rDto=new RoomDTO();
		if(r!=null) {
			BeanUtils.copyProperties(r, rDto);
		}
		return rDto;
	}
}
