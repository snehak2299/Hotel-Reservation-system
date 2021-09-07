package com.bridglabz.hotelreservationtest;

import java.util.ArrayList;

import org.junit.Test;

import com.bridglabz.hotelresrvationsystem.HotelReservation;

public class HotelReservationTest {
	public ArrayList<HotelReservation> nameOfhotel = new ArrayList<>();
	HotelReservation hotelReservation;
	
	
	@Test
	public void insertHotel_ifDataCorrect() {
		HotelReservation hotelLakewoodRegular = new HotelReservation("lakewood", 110, 90, 80, 80, 3);
		nameOfhotel.add(hotelLakewoodRegular);
		
		HotelReservation hotelBridgewoodRegular = new HotelReservation("Bridgwood", 160, 60, 110, 50, 4);
		nameOfhotel.add(hotelBridgewoodRegular);
		
		HotelReservation hotelRidgewoodRegular = new HotelReservation("Ridgewood", 220, 150, 100, 40, 5);
		nameOfhotel.add(hotelRidgewoodRegular);
		 
		HotelReservation hotelBridgewoodReward = new HotelReservation("Bridgwood", 160, 60, 110, 50, 4);
		nameOfhotel.add(hotelBridgewoodReward);
		
		HotelReservation hotelLakewoodReward = new HotelReservation("Lakewood",110, 90, 80, 80, 3);
		nameOfhotel.add(hotelLakewoodReward);
		
		HotelReservation hotelRidgewoodReward = new HotelReservation("Ridgwood",220, 150, 100, 40, 5);
		nameOfhotel.add(hotelRidgewoodReward);
	}
	
	
	

}
