package com.hm.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.dto.RoomDTO;
import com.hm.entity.Booking;
import com.hm.entity.Room;
import com.hm.entity.RoomType;
import com.hm.exception.ResourceNotFoundException;
import com.hm.repository.BookingRepository;
import com.hm.repository.RoomRepository;
import com.hm.service.RoomService;
import com.hm.utils.RoomConverter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {
	
//	logger created
	private static final Logger log=LoggerFactory.getLogger(Room.class);


	@Autowired
	RoomConverter roomConvert;
	
	@Autowired
	RoomRepository roomRepo;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public RoomDTO createRoom(Room r) {
		r.calculatePrice();
		roomRepo.save(r);
		
		log.info(" New Room details "+r.toString()+ "saved at " +new Date());
		return  roomConvert.convertRmEntityToDto(r);
	}

	@Override
	public List<RoomDTO> getAllRoom() {
		List<Room>room=roomRepo.findAll();
		List<RoomDTO>rDto=new ArrayList<>();
		
		for(Room r:room) {
		rDto.add(roomConvert.convertRmEntityToDto(r));
		}
		log.info("All Room details fetched at "+new Date());

		return rDto;
		
		
	}

	@Override
	public RoomDTO getRoomById(int id) throws ResourceNotFoundException {
		Room r=roomRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Room", "id", id));
		return roomConvert.convertRmEntityToDto(r);
		
	}

	@Override
	public RoomDTO updateRoomDetail(int rId, Room r) throws ResourceNotFoundException {
		Room room=roomRepo.findById(rId).orElseThrow(()-> new ResourceNotFoundException("Room", "id", rId));
		room.setRoomType(r.getRoomType());
		room.setAvailable(r.isAvailable());
		roomRepo.save(room);
		return roomConvert.convertRmEntityToDto(room);
		
	}

	@Override
	public void deleteRoomById(int id) {
		Room r=roomRepo.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Room","id" ,id ));
			roomRepo.deleteById(id);
		
	}

	@Override
	public void RoomAssignedToBooking(int rId, int bId) {
		Room r=roomRepo.findById(rId).orElseThrow(()-> new ResourceNotFoundException("Room", "id", rId));
		Booking b=bookingRepository.findById(bId).orElseThrow(()-> new ResourceNotFoundException("Booking", "id", bId));
		b.setRoom(r);
		
		roomRepo.save(r);
		bookingRepository.save(b);
		
	}

	@Override
	public List<Room> findByRoomTypeAndAvailable(RoomType roomTypeEnum, boolean available) {
		
		return roomRepo.findByRoomTypeAndAvailable(roomTypeEnum, true);
	}
	


}
