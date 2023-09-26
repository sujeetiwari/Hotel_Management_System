package com.hm.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hm.entity.Customer;
import com.hm.entity.Hotel;
import com.hm.entity.Room;
import com.hm.entity.RoomType;

import lombok.Data;

@Data
public class BookingDTO {

	private int bookingId;

	@NotNull(message = "Check-In date is required")
	private LocalDate checkInDate; // yyyy-mm-dd

	@NotNull(message = "Check-Out date is required")
	private LocalDate checkOutDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private RoomType roomType;

	private double price;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	private Hotel hotel;

	@OneToOne
	private Room room;

	public void calculatePrice() {
		price = roomType.getPrice();
	}

}
