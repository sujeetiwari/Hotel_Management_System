package com.hm.service;

import org.springframework.stereotype.Service;

import com.hm.entity.RoomType;

@Service
public class RoomTypeService {
	
	 public RoomType convertStringToRoomType(String roomTypeString) {
	        try {
	            return RoomType.valueOf(roomTypeString.toUpperCase()); // Convert the String to RoomType enum
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Invalid room type: " + roomTypeString);
	        }
	    }

}
