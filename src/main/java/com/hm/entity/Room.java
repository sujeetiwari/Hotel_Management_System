package com.hm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;

	@Column(nullable=false)
	private boolean available;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=20)
	private RoomType roomType;
	
	private double price;
	
	 public void calculatePrice() {
		 price = roomType.getPrice();
	    }
}
