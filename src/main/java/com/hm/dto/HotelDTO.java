package com.hm.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hm.entity.Booking;

import lombok.Data;

@Data
public class HotelDTO {

	private int id;

	@NotNull(message = " Hotel Name is required")
	@Size(max = 20, message = "Maximum 20 character is allowed")
	@Size(min = 3, message = "Minimum 3 character is allowed")
	private String hotelName;

	@NotNull(message = " Location is required")
	@Size(max = 20, message = "Maximum 20 character is allowed")
	@Size(min = 3, message = "Minimum 3 character is allowed")
	private String location;

	@NotNull(message = "Rating is required")
	private int rating;

	@OneToMany
	private List<Booking> booking;

}