package com.synergy.service;
import java.time.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synergy.client.BookingHotelClient;
import com.synergy.domain.Booking;
import com.synergy.domain.Guest;
import com.synergy.model.Availability;
import com.synergy.model.DisplayBooking;
import com.synergy.repository.BookingRepository;
@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;
	
	
	@Autowired
	BookingHotelClient bookingclient;
	
    @Override
    public boolean  checkAvailability(Availability aval)   {
		int totalRooms=aval.getInventory();
		int NoOfRoomsAlreadyBooked=0;
		List<Booking> listbooking= bookingRepository.findByHotelIdAndHotelRoomIdAndRoomTypeAndStatusAllIgnoreCase(aval.getHotelId(),aval.getHotelRoomId(), aval.getRoomType(),"upcoming");		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
			Date checkInDate = format.parse(aval.getCheckInDate());
			Date checkOutDate = format.parse(aval.getCheckOutDate());			
			Timestamp checkInDateTimestamp = new Timestamp(checkInDate.getTime());
	        Timestamp checkOutDateTimestamp = new Timestamp(checkOutDate.getTime());
	        
	        for(Booking str:listbooking) {
	        	
	    		if((checkInDateTimestamp.after(str.getCheckInDate()) && checkInDateTimestamp.before(str.getCheckOutDate())) )
	    		{	NoOfRoomsAlreadyBooked +=str.getNoRooms();	System.out.println("NoOfRoomsAlreadyBooked first if " + NoOfRoomsAlreadyBooked);	}
	    		else if(checkOutDateTimestamp.after(str.getCheckInDate())&& checkOutDateTimestamp.before(str.getCheckOutDate()) ) 
	    		{	NoOfRoomsAlreadyBooked +=str.getNoRooms(); System.out.println("NoOfRoomsAlreadyBooked second if" + NoOfRoomsAlreadyBooked); }
	    		else if (checkInDateTimestamp.before(str.getCheckInDate()) && checkOutDateTimestamp.after(str.getCheckOutDate()))
	    		{	 NoOfRoomsAlreadyBooked +=str.getNoRooms();  System.out.println("NoOfRoomsAlreadyBooked third  if " + NoOfRoomsAlreadyBooked);} 
	    		else if (checkInDateTimestamp.equals(str.getCheckInDate())|| checkOutDateTimestamp.equals(str.getCheckOutDate())) {
	    			NoOfRoomsAlreadyBooked +=str.getNoRooms();  System.out.println("NoOfRoomsAlreadyBooked fourth  if " + NoOfRoomsAlreadyBooked);
	    		}
	    	 }
		  }catch (ParseException e) {
		    e.printStackTrace();
		  }	
        int roomsAvailable=totalRooms-NoOfRoomsAlreadyBooked;
        
        if(aval.getNoRooms()<=roomsAvailable)
	       return true;
        else
           return false;
     }
    
    
    @Override
    public Booking saveBooking(Booking booking) { 
    	
    	Set<Guest> guestset= booking.getGuests();
    	for( Guest g:guestset) {
    		System.out.println(g.getFirstName());
    		System.out.println(g.getLastName());
    		System.out.println(g.getGender());
    		System.out.println(g.getAge());
    	}
    	return bookingRepository.save(booking);
    }

    @Override
	public List<DisplayBooking> getBookingsByUser(String usermobile) {
    	
		List<Booking> listbooking=bookingRepository.findByCustomerMobile(usermobile);
		ObjectMapper mapper=new ObjectMapper();
		JsonNode node=mapper.createObjectNode();
		System.out.println("booking list size"+listbooking.size()); 		
		List<DisplayBooking> displaylist=new ArrayList<>();		
		for (Booking str:listbooking) {
		    JsonNode hotelname1=bookingclient.getHotelName(str.getHotelId());
			String hotelname=hotelname1.get("hotelname").asText();
			Date checkindate =new Date(str.getCheckInDate().getTime());
	        String checkin=DateFormat.getInstance().format(checkindate).toString();
	        System.out.println("booking checkin date " +checkin);
	        Date checkoutdate =new Date(str.getCheckOutDate().getTime());
	        String checkout=DateFormat.getInstance().format(checkoutdate).toString();
	        DisplayBooking db=new DisplayBooking(str.getBookingId(),str.getHotelId(),hotelname,str.getRoomType(),checkin,checkout,str.getStatus(), str.getNoRooms(),str.getPrice());
	        displaylist.add(db);
		}
		return displaylist;
	}

    
    @Override
	public String changeBookingStatus(int bookingId) {
    	System.out.println("inside booking service changeBookingStatus");
		
		Booking booking =bookingRepository.findByBookingId(bookingId);
		System.out.println("inside booking service changeBookingStatus 1");
		 booking.setStatus("Cancelled");
		 System.out.println("inside booking service changeBookingStatus 2");
		// String s =booking.getStatus();
		 //System.out.println("Status"+s);
		 bookingRepository.save(booking);
		 
		 System.out.println("inside booking service changeBookingStatus 3");
		 
		 
		return booking.getStatus();
	}

    

}
