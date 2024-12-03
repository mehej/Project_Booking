package com.synergy.controller;
import java.security.Principal;


import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synergy.client.BookingHotelClient;
import com.synergy.domain.Booking;
import com.synergy.model.Availability;
import com.synergy.model.DisplayBooking;
import com.synergy.service.BookingServiceImpl;

@RestController
public class BookingController {
	
	@Autowired
	BookingServiceImpl bookingServiceimpl;
	@Autowired
	BookingHotelClient bookinghotelclient;	
	
	
	@RequestMapping(value="/chkAvlblty" ,method = RequestMethod.POST)
	public boolean chkAvlblty(@RequestBody Availability aval){
	System.out.println("in Booking Controller");
	System.out.println("aval.getHotelRoomId()" + aval.getHotelRoomId());
	 return bookingServiceimpl.checkAvailability(aval);
		}
	
	@RequestMapping(value="/confirmBooking" ,method = RequestMethod.POST)
	public Booking confirmBooking(@RequestBody Booking booking){
	
	
	return bookingServiceimpl.saveBooking(booking);
		}
	
	
	@RequestMapping(value="/getBookingsByUser/{usermobile}")
	public List<DisplayBooking> getBookingsByUser(@PathVariable String usermobile) {
		System.out.println("in booking controller my getBookingsByUser");
	  return bookingServiceimpl.getBookingsByUser(usermobile);
	 
}
	
	
		@RequestMapping(value="/getHotelName/{hotelId}")
		public JsonNode getHotelName(@PathVariable int hotelId) {
			System.out.println("in booking controller my getBookingsByUser");
		  return bookinghotelclient.getHotelName(hotelId);
		 
	}
		@RequestMapping(value="/changeBookingStatus/{bookingId}")
		public String changeBookingStatus(@PathVariable int bookingId) {		
		String s= bookingServiceimpl.changeBookingStatus(bookingId);
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.createObjectNode();
		((ObjectNode) node).put("status",s);
		return s;
		
		}
		
		
		
		
	}
	
	
	
	
	

