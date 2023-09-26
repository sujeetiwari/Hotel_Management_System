package com.hm.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class AdminDTO {

		private int id;
	
	
	    private String adminName;
	
		@NotNull(message="Email is required")
		@Size(max=30,message="Maximum 30 character is allowed")
		@Email(message="Invalid E-Mail")
		@NotBlank(message="Enter valid email")
		private String email;
		
		
	    private String password;
	
     	
	
}
