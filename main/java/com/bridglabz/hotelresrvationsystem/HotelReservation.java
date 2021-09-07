package com.bridglabz.hotelresrvationsystem;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelReservation {
	public ArrayList<HotelReservation> nameOfhotel = new ArrayList<>();
	String name;
	Integer rating;
	HashMap<CustomerType,Rate> rates;
	

	public HotelReservation() {
		
	}

	
	public void add(HotelReservation hotelReservation)
	{
	  this.nameOfhotel.add(hotelReservation);
	}
	
	public HotelReservation( String name, Integer rating,
		Map<CustomerType, Rate> rates) {
		super();
		this.name = name;
		this.rating = rating;
		this.rates = (HashMap<CustomerType, Rate>) rates;
		
	}
	public ArrayList<HotelReservation> getNameOfhotel() {
		return nameOfhotel;
	}


	public void setNameOfhotel(ArrayList<HotelReservation> nameOfhotel) {
		this.nameOfhotel = nameOfhotel;
	}


	public String getName() {
		return name;
	}

	public Integer getRating() {
		return rating;
	}

	public Map<CustomerType, Rate> getRates() {
		return rates;
	}


	public void cheapeastHotel(LocalDate start, LocalDate end){
        ArrayList<LocalDate> Dates = new ArrayList<LocalDate>(3);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String myFormatDate = start.format(df);
        
        Dates.add(start);
        long diff = ChronoUnit.DAYS.between(start, end);

        while (diff>0){
            Dates.add(Dates.get(Dates.size()-1).plusDays(1));
            diff--;
        }

       Integer[] rate=new Integer[] {0,0,0};
		
		Dates.stream().forEach(n->{
			for(int i=0;i<nameOfhotel.size();i++) {
				if (n.getDayOfWeek().getValue() == 6 || n.getDayOfWeek().getValue() == 7) {
					rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Regular).weekendRate;
				}
				else {
					rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Regular).weekdayRate;
				}
			}
		});
		
		Integer n = Arrays.asList(rate).indexOf(Collections.min(Arrays.asList(rate)));
		
        System.out.println("Cheapest hotel for given date is " + nameOfhotel.get(n).name + " with price "+ rate+ "with total rating of "+nameOfhotel.get(n).getRating());
    }


	
}
