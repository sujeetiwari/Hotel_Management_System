package com.hm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor


public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 20, nullable = false)
	private String hotelName;

	@Column(length = 20, nullable = false)
	private String location;

	@Column(name = "rating", nullable = false)
	private int rating;

	@OneToMany
	private List<Booking> booking;

	@Builder
	public Hotel(int id, String hotelName, String location, int rating, List<Booking> booking) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		this.rating = rating;
		this.booking = booking;
	}

}
