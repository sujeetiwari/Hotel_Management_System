package com.hm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hm.dto.HotelDTO;
import com.hm.dto.RoomDTO;
import com.hm.entity.Hotel;
import com.hm.entity.Room;
import com.hm.entity.RoomType;
import com.hm.service.RoomService;
import com.hm.service.RoomTypeService;
import com.hm.utils.RoomConverter;

@RestController
public class RoomController {

	@Autowired
	RoomService roomService;

	@Autowired
	RoomConverter roomConverter;

	@Autowired
	RoomTypeService roomTypeService;

	@PostMapping("/saveRoom")
	public RoomDTO createRoom(@Valid @RequestBody RoomDTO rDTo) {

		Room r = roomConverter.convertRmDtoToEntity(rDTo);
		return roomService.createRoom(r);

	}

	@GetMapping("/getAllRoom")
	public List<RoomDTO> getAllRoom() {
		return roomService.getAllRoom();
	}

	@GetMapping("/getRoomById/{id}")
	public RoomDTO getRoomById(@PathVariable("id") int rId) {
		return roomService.getRoomById(rId);
	}

	@PutMapping("/updateRoom/{rId}")
	public RoomDTO updateRoom(@PathVariable("rId") int rId, @RequestBody @Valid RoomDTO rDTO) {
		final Room r = roomConverter.convertRmDtoToEntity(rDTO);
		return roomService.updateRoomDetail(rId, r);
	}

	@DeleteMapping("/deleteRmById/{id}")
	public ResponseEntity<String> deleteRmById(@PathVariable("id") int id) {
		roomService.deleteRoomById(id);
		return new ResponseEntity<String>("Room with id" + id + " deleted success ", HttpStatus.OK);
	}

	@PostMapping("/assignedRm/{rId}/toBk/{bId}")
	public ResponseEntity<String> assignedRmtoBk(@PathVariable("rId") int rId, @PathVariable("bId") int bId) {
		roomService.RoomAssignedToBooking(rId, bId);
		return new ResponseEntity<String>("Room with id " + rId + " assigned to " + bId, HttpStatus.OK);
	}

	@GetMapping("/checkRoom/{roomType}/{available}")
	public List<Room> findByRoomTypeAndAvailable(@PathVariable("roomType") String roomType,
			@PathVariable("available") boolean available) {

		RoomType roomTypeEnum = roomTypeService.convertStringToRoomType(roomType); // Assuming you have a
																					// roomTypeService
		return roomService.findByRoomTypeAndAvailable(roomTypeEnum, available);
	}
}
