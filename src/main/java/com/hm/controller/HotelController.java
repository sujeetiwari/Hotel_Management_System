package com.hm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hm.dto.HotelDTO;
import com.hm.entity.Hotel;
import com.hm.service.HotelService;
import com.hm.utils.HotelConverter;




@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api")
public class HotelController {
	
	@Autowired
	HotelConverter hotelConvert;

	@Autowired
	HotelService hotelService;

	@PostMapping("/saveHotel")
	public HotelDTO createHotel(@Valid @RequestBody HotelDTO hDto) {

		Hotel h = hotelConvert.convertHlDtoToEntity(hDto);

		return hotelService.createHotel(h);
	}
	
	@GetMapping("/getAllHotel")
		public List<HotelDTO> getAllHotel(){
			return hotelService.getAllHotel();	
	}
	
	@GetMapping("/getHotelById/{id}")	
	public HotelDTO getHotelById(@PathVariable("id") int hId) {
		return hotelService.getHotelById(hId);
	}
	
	@PutMapping("/updateHotel/{hId}")
	public HotelDTO updateHotel(@PathVariable("hId") int hId,
	@RequestBody @Valid		HotelDTO hDTO) {
		final Hotel h=hotelConvert.convertHlDtoToEntity(hDTO);
		 return hotelService.updateHotelDetail(hId, h);
	}
	
	@DeleteMapping("/deleteHlById/{id}")
	public ResponseEntity<String> deleteHlById(@PathVariable("id") int id) {
		hotelService.deleteHotelById(id);
		return new ResponseEntity<String>("Hotel with id"+id+" deleted success ", HttpStatus.OK );
	}
	
	@PostMapping("/assignedHl/{hId}/toBk/{bId}")
	public ResponseEntity<String>assignedHltoBk(@PathVariable("hId") int hId ,@ PathVariable ("bId") int bId){
		hotelService.hotelAssignedToBooking(hId, bId);
		return new ResponseEntity<String>("Hotel with id "+hId+ "assigned to"+bId,HttpStatus.OK);
	}
	
	@GetMapping("/getHotelByLocation/{location}")
	public List<HotelDTO> getHlByLocation(@PathVariable("location") String location)
	{
		return hotelService.getHotelByLocation(location);
	}

}
