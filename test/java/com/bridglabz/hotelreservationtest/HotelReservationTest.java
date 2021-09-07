package com.bridglabz.hotelreservationtest;
import java.time.LocalDate;
import java.util.ArrayList;
import java. util. HashMap;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridglabz.hotelresrvationsystem.CustomerType;
import com.bridglabz.hotelresrvationsystem.HotelReservation;
import com.bridglabz.hotelresrvationsystem.Rate;

public class HotelReservationTest {
	public ArrayList<HotelReservation> hotel = new ArrayList<HotelReservation>();
	HotelReservation hotelReservation;
	
	
	@Before
	public void insertHotel_ifDataCorrect() throws Exception {
		HashMap<CustomerType,Rate> map = new HashMap<>();
		HashMap<CustomerType,Rate>customerTypeRate = new HashMap<>();
		customerTypeRate.put(CustomerType.Regular,new Rate(110,90));
		customerTypeRate.put(CustomerType.Rewarded,new Rate(110,90));
		HotelReservation lakewood = new HotelReservation("Lakewood",3,customerTypeRate);
		hotel.add(lakewood);
		
		map = new HashMap<>();
		map.put(CustomerType.Regular, new Rate(160,60));
		map.put(CustomerType.Rewarded, new Rate(110,50));	
		HotelReservation bridgewood = new HotelReservation("bridgewood",4,map);
		hotel.add(bridgewood);
		
		customerTypeRate.put(CustomerType.Regular,new Rate(110,90));
		customerTypeRate.put(CustomerType.Rewarded,new Rate(110,90));
		HotelReservation ridgewood = new HotelReservation("ridgewood",5,customerTypeRate);
		hotel.add(ridgewood);
	}

	@Test
    public void ifChipestHotel_returnNamePrice() {
		LocalDate start = LocalDate.parse("09Sep2021");
		LocalDate end = LocalDate.parse("10Sep2021");
//	
        hotelReservation.cheapeastHotel(start,end);
    }
}
