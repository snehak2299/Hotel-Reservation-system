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
	public void findHotel_CheapestRatingAmongAll_ShouldReturnHotelName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservation = new HotelReservation();
		String name = hotelReservation.bestRatedHotel(inputDate);
		Assert.assertEquals("Bridgewood, Rating: 4 and  Rates: 200", name);
		
	}
	@Test
	public void findHotelName_BestRatingAmongAll_ShouldReturnHotelName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservation = new HotelReservation();
		String name = hotelReservation.bestRatedHotelName(inputDate);
		Assert.assertEquals("Ridgewood, Total Rates: 370", name);
		
	}
	@Test
	public void findHotelName_CheapestAll_ShouldReturnHotelName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservation = new HotelReservation();
		String name = hotelReservation.calculateHotel(inputDate);
		Assert.assertEquals("Lakewood, Total Rates: 220", name);
		
	}
	@Test
	public void findHotelName_AllCheapestHotel_ShouldReturnNameWithTotalRate() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservation = new HotelReservation();
		String name = hotelReservation.calculateHotel(inputDate);
		Assert.assertEquals("Lakewood and Bridgewood, Total Rates: 200", name);
		
	}
	@Test
	public void findHotelName_BestRatingAmongChpeast_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = "11Sep2020,12Sep2020";
		hotelReservation = new HotelReservation();
		String name = hotelReservation.bestRatedHotelName(inputDate);
		Assert.assertEquals("Ridgewood, Rating: 5 and Total Rates: 140", name);
		
	}
	@Test
    public void findHotelName_BestRatedCheapestForRegularC_ShouldReturnName() {
        String inputDate ="11Sep2020,12Sep2020";
        hotelReservation= new HotelReservation();
        String name = hotelReservation.BestRatedCheapHotelForRegular(inputDate);
        Assert.assertEquals("Best rated cheap hotel for rewarded: Bridgewood, Rate: 200 Ratings: 4", name);

    }
}
