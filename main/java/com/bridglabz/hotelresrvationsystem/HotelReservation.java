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

        Integer[] price ={0,0,0};
        for (int i=0; i<Dates.size(); i++){
            for (int j=0; j<nameOfhotel.size(); j++) {

                if (Dates.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || Dates.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += nameOfhotel.get(j).rates.get(CustomerType.Regular).weekendRate;
                }
                else
                    price[j] += nameOfhotel.get(j).rates.get(CustomerType.Rewarded).weekdayRate;
            }
        }

        int n = Arrays.asList(price).indexOf(Collections.min(Arrays.asList(price)));
        System.out.println("Cheapest hotel for given date is " + nameOfhotel.get(n).name + " with price "+ price);
    }


	
}
