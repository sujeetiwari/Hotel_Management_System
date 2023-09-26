package com.hm.service;

import java.util.List;

import com.hm.dto.HotelDTO;
import com.hm.dto.RoomDTO;
import com.hm.entity.Room;
import com.hm.entity.RoomType;
import com.hm.exception.ResourceNotFoundException;

public interface RoomService {
	
//	method to create Room
	RoomDTO createRoom(Room r);
	
//	method to get all room
	List<RoomDTO>getAllRoom();

//	method to room by id
	RoomDTO getRoomById(int id) throws ResourceNotFoundException ;
	
//	method to update
	RoomDTO updateRoomDetail(int rId,Room r) throws ResourceNotFoundException;
	
//	method to delete
	void deleteRoomById(int id);
	
//	method to assigned room to booking
	void RoomAssignedToBooking(int rId,int bId);
	
	List<Room >findByRoomTypeAndAvailable(RoomType roomTypeEnum, boolean available);


}
