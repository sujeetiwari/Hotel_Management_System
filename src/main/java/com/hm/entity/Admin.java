package com.hm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor


public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false,length=20)
	private String adminName;
	
	@Column(nullable=false,length=30,unique=true)
	private String email;
	
	@Column(nullable=false,length=20)
	private String password;
	
	@Builder
	public Admin(int id, String adminName, String email, String password) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.email = email;
		this.password = password;
	}


	

}
