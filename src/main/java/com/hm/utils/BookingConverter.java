package com.hm.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.hm.dto.BookingDTO;
import com.hm.entity.Booking;
import com.hm.entity.Customer; // Import the Customer entity if it's not imported already.

@Component
public class BookingConverter {
    
    public Booking convertBkDtoToEntity(BookingDTO bDto) {
        Booking b = new Booking();
        if (bDto != null) {
            BeanUtils.copyProperties(bDto, b);
        }
        return b;
    }
// method to convert booking entity
    public BookingDTO convertBkEntityToDto(Booking booking) {
        BookingDTO bDto = new BookingDTO();
        if (booking != null) {
            BeanUtils.copyProperties(booking, bDto);
            
                   }
        return bDto;
    }
}
