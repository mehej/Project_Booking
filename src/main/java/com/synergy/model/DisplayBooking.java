package com.synergy.model;

public class DisplayBooking {
	
	
	private int bookingId;
	private int hotelId;
	private String hotelName;
	private String roomType;
	private String checkInDate;	
	private String checkOutDate;
	private String status;
	private int noRooms;
	private float price;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public DisplayBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	
	public DisplayBooking(int bookingId, int hotelId, String hotelName, String roomType, String checkInDate,
			String checkOutDate, String status, int noRooms, float price) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.status = status;
		this.noRooms = noRooms;
		this.price = price;
	}	
	
	
	

}
