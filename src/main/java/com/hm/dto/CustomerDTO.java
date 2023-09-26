package com.hm.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.hm.entity.Booking;

import lombok.Data;

@Data
public class CustomerDTO {

	private int customerId;

	@NotNull(message = "Name is required")
	@Size(max = 30, message = "Maximum 30 character is allowed")
	@Size(min = 2, message = "Minimum 2 character is allowed")
	@NotBlank(message = "Enter valid name")
	private String customerName;

	@NotNull(message = "Gender is required")
	@Size(min = 4, message = "min is 4 th character")
	@Size(max = 10, message = "max is 10th character")
	private String gender;

	@NotNull(message = "Address is required")
	@Size(max = 50, message = "Maximum 50 character is allowed")
	private String address;

	@NotNull(message = "Contact is required")
	@Size(min = 10, max = 10, message = "10 characters required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Invalid Contact details")
	private String contact;

	@NotNull(message = "Email is required")
	@Size(max = 30, message = "Maximum 30 character is allowed")
	@Email(message = "Invalid E-Mail")
	@NotBlank(message = "Enter valid email")
	private String email;

	private String password;

	@OneToMany
	private List<Booking> booking;

}
