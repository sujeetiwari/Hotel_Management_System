package com.hm.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.hm.entity.RoomType;

import lombok.Data;

@Data
public class RoomDTO {
	
	private int roomId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=20)
	@NotNull(message="Room Type is required")
	private RoomType roomType;

	@NotNull(message="AvailableRoom is required")
	private boolean available;
	

	private double price;
	
	public void calculatePrice() {
		 price = roomType.getPrice();
	    }

}
