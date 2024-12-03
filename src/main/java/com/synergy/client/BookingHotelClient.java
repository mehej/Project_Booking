package com.synergy.client;

import org.springframework.stereotype.Component;



import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class BookingHotelClient {

	
	
	public JsonNode getHotelRoomsDetails(int Hotelid,String roomtype) {
		System.out.println("Inside bookingHotelClient ");
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);        
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getHotelRoomsDetails/hotelid/{Hotelid}/roomtype/{roomtype}",Object.class,Hotelid,roomtype);
	    Object objects = responseEntity.getBody();    
	    ObjectMapper mapper = new ObjectMapper();    
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	    System.out.println("success");
	        return returnObj;
	}

	public JsonNode getHotelName(int hotelId) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);        
	    RestTemplate restTemplate = new RestTemplate();
	    System.out.println("inside booking hotel client ");
	    ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getHotelName/"+hotelId, Object.class);
	    Object objects = responseEntity.getBody();
	    System.out.println("inside booking hotel client success");
	    ObjectMapper mapper = new ObjectMapper();    
	    JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
	        return returnObj;
		
		
	}

	


	
}
