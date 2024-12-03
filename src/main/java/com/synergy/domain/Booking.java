package com.synergy.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingId;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	private int hotelId; //communicates with hotel management to fetch hotel details
	private int hotelRoomId;	
	private int noRooms;
	private Timestamp checkInDate;
	private Timestamp checkOutDate;
	private Timestamp bookedOnDate;
	private String status; //cancelled, completed (can be simply compared), upcoming
	private float price;
	private float discount;	
	private String customerMobile; //identify the customer who booked
	private String roomType;
	@ManyToMany(cascade = CascadeType.ALL)	
	private Set<Guest> guests;
	
	//@Transient
	//private String hotelName;	
	
	//public String getHotelName() {
	//	return hotelName;
	//}
	//public void setHotelName(String hotelName) {
	//	this.hotelName = hotelName;
	//}
	public String getRoomType() {
		return roomType;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingId, int hotelId, int hotelRoomId, int noRooms, Set<Guest> guests, Timestamp checkInDate,
			Timestamp checkOutDate, Timestamp bookedOnDate, String status, float price, float discount,
			String customerMobile, String roomType) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.hotelRoomId = hotelRoomId;
		this.noRooms = noRooms;
		this.guests = guests;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookedOnDate = bookedOnDate;
		this.status = status;
		this.price = price;
		this.discount = discount;
		this.customerMobile = customerMobile;
		this.roomType = roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	public Set<Guest> getGuests() {
		return guests;
	}
	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}
	public Timestamp getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Timestamp checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Timestamp getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Timestamp checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Timestamp getBookedOnDate() {
		return bookedOnDate;
	}
	public void setBookedOnDate(Timestamp bookedOnDate) {
		this.bookedOnDate = bookedOnDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	
	
}
