package com.hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.entity.Room;
import com.hm.entity.RoomType;

public interface RoomRepository  extends JpaRepository<Room, Integer>{

//	custom method to fetch to check room available
	List<Room> findByRoomTypeAndAvailable(RoomType roomTypeEnum,boolean available);

}
