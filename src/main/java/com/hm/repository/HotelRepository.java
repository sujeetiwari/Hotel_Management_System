package com.hm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hm.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
//	custom method to fetch hotel by location
	@Query("from Hotel where location=:x")
	List<Hotel> getHotelByLocation(@Param("x") String location);

}
