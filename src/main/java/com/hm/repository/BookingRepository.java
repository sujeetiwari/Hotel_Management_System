package com.hm.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	

	
}
