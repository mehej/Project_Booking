package com.synergy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	public List<Booking> findByHotelIdAndHotelRoomIdAndRoomTypeAndStatusAllIgnoreCase(int hotelId,int hotelRoomId,String RoomType,String status);
	public List<Booking> findByCustomerMobile(String usermobile);
	public Booking findByBookingId(int bookingId);

}
