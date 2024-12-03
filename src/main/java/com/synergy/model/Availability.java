package com.synergy.model;



public class Availability {
	
	private int hotelId;
	private int hotelRoomId;	
	private String hotelName;
	private int noRooms;
	private int noGuests;	
	private String checkInDate;	
	private String checkOutDate;
	private String roomType;
	private int inventory;
	
	
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public int getNoGuests() {
		return noGuests;
	}
	public void setNoGuests(int noGuests) {
		this.noGuests = noGuests;
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
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public Availability(int hotelId, String hotelName, int noRooms, int noGuests, String checkInDate,
			String checkOutDate, String roomType , int inventory,int hotelRoomId) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.noRooms = noRooms;
		this.noGuests = noGuests;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomType = roomType;
		this.inventory=inventory;
		this.hotelRoomId=hotelRoomId;
	}
	public Availability() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

