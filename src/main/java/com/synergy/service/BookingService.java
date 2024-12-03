package com.synergy.service;
import java.util.List;


import com.fasterxml.jackson.databind.JsonNode;
import com.synergy.domain.Booking;


import com.synergy.model.Availability;
import com.synergy.model.DisplayBooking;

public interface BookingService {
	
	public boolean checkAvailability (Availability aval);
	public Booking saveBooking(Booking booking);
	public List<DisplayBooking> getBookingsByUser(String usermobile);
	public String changeBookingStatus(int bookingId);
	

	
	

}
