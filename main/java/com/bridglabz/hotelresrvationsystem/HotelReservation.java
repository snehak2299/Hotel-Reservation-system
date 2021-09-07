package com.bridglabz.hotelresrvationsystem;

import java.util.ArrayList;

public class HotelReservation {
	public ArrayList<HotelReservation> nameOfhotel = new ArrayList<>();
	
	String hotelName;
	//String typeOfCustomer;
	int weekDaysRegular;
	int weekEndsRegular;
	int weekDaysReward;
	int weekendReward;
	int rates;
	
	public HotelReservation(String hotelName,int weekDaysRegular, int weekEndsRegular, int weekDaysReward,
			int weekendReward, int rates) {
		super();
		this.hotelName = hotelName;
		//sthis.typeOfCustomer = typeOfCustomer;
		this.weekDaysRegular = weekDaysRegular;
		this.weekEndsRegular = weekEndsRegular;
		this.weekDaysReward = weekDaysReward;
		this.weekendReward = weekendReward;
		this.rates = rates;
	}

	
	public void add(HotelReservation hotelReservation)
	{
	nameOfhotel.add(hotelReservation);
	}
}
