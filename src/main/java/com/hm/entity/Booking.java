package com.hm.entity;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@Column(nullable = false)
	private LocalDate checkInDate;

	@Column(nullable = false)
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

	public void calculatePrice() {
		price = roomType.getPrice();
	}

	@OneToOne
	private Room room;

	@Builder
	public Booking(int bookingId, LocalDate checkInDate, LocalDate checkOutDate, RoomType roomType, double price,
			Customer customer, Hotel hotel, Room room) {
		super();
		this.bookingId = bookingId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.price = price;
		this.customer = customer;
		this.hotel = hotel;
		this.room = room;
	}

}
