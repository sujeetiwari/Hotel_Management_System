package com.hm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor


public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(nullable=false,length=20)
	private String customerName;
	
	@Column(length=10,nullable=false)
	private String gender;
	
	@Column(length=20,nullable=false)
	private String address;
	
	@Column(length=20,nullable=false)
	private String password;
	
	@Column(length=10,nullable=false,unique=true)
	private String contact;
	
	@Column(length=30,nullable=false,unique=true)
	private String email;
	
	@OneToMany
	private List<Booking>booking;
	
	@Builder
	public Customer(int customerId, String customerName, String gender, String address, String password, String contact,
			String email, List<Booking> booking) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.contact = contact;
		this.email = email;
		this.booking = booking;
	}

	



}
