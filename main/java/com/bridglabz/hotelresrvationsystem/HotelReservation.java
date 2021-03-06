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
import java.util.stream.Collectors;
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


	public String bestRatedHotel(String inputDate) {

		String[] names = resultHotel(inputDate);
		String[] hotel = names[0].split(" and ");
		
		Map<String,Integer> ratingName = new HashMap<>();
		Integer ratings= 0;
		for(String n: hotel){
			for(int i=0;i<nameOfhotel.size();i++) {
				if (nameOfhotel.get(i).name.equals(n)) {
					ratingName.put(n, nameOfhotel.get(i).rating);
					ratings = Math.max(ratings, nameOfhotel.get(i).rating);
				}
			}
		}
		final Integer ratingsD = ratings;
		ArrayList<String> ratedHotel = Arrays.asList(hotel).stream().filter(n -> ratingName.get(n).equals(ratingsD)).collect(Collectors.toCollection(ArrayList::new));
		
		return String.join(" and ", ratedHotel) + ", Rating: " + ratings + " and Total Rates: "+names[1];
	}
	public String[] resultHotel(String inputDate){
		String[] inputArr = inputDate.split(",");
		DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		ArrayList<LocalDate> dateArr = new ArrayList<>();
		dateArr.add(LocalDate.parse(inputArr[0],fomat));
		long diff = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));
		
		while(diff>0) {
			dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
			diff--;
		}
		
		Integer[] rate=new Integer[] {0,0,0};
		ArrayList<String> nameHotel = new ArrayList<String>();
		
		dateArr.stream().forEach(n->{
			for(int i=0;i<nameOfhotel.size();i++) {
				if (n.getDayOfWeek().getValue() == 6 || n.getDayOfWeek().getValue() == 7) {
					rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Regular).weekdayRate;
				}
				else {
					rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Regular).weekendRate;
				}
			}
		});
		//Added this for adding multiple hotel name
				Integer value = Collections.min(Arrays.asList(rate));
				
				for(int i=0;i<rate.length;i++) {
					if (rate[i].equals(value)) {
						nameHotel.add(nameOfhotel.get(i).name);
					}
				}
				String[] names = new String[2];
				names[0]= String.join(" and ", nameHotel);
				names[1]= String.valueOf(value);
				return names;
	
	}
	public String calculateHotel(String inputDate){
		
		String[] names = resultHotel(inputDate);
		return names[0] + ", Total Rates: "+ Integer.valueOf(names[1]);
	}
	
	public String bestRatedHotelName(String inputDate) {
		String[] inputArr = inputDate.split(",");
		DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		ArrayList<LocalDate> dateArr = new ArrayList<>();
		dateArr.add(LocalDate.parse(inputArr[0],fomat));
		long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));
		while(noOfDaysBetween>0) {
			dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
			noOfDaysBetween--;
		}
		
		Integer[] rate=new Integer[] {0,0,0};
		ArrayList<String> nameOfHotel = new ArrayList<String>();
		
		dateArr.stream().forEach(n->{
			for(int i=0;i<nameOfHotel.size();i++) {
				if (n.getDayOfWeek().getValue() == 6 || n.getDayOfWeek().getValue() == 7) {
					rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Regular).weekendRate;
				}
				else {
					rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Regular).weekdayRate;
				}
			}
			
			
		});
		// to find cheap best rated hotel
		Integer ratings= 0;
		for(int i=0;i<nameOfHotel.size();i++) {
			ratings = Math.max(ratings, nameOfhotel.get(i).rating);
		}
		
		final Integer ratingsD = ratings;
		ArrayList<HotelReservation> highRatedHotel = nameOfhotel.stream().filter(n-> n.rating.equals(ratingsD)).collect(Collectors.toCollection(ArrayList::new));
		
		ArrayList<String> hotelNameVariable= new ArrayList<>();
		
		Integer value =0;
		for(int i=0;i<highRatedHotel.size();i++) {
			for(int j=0;j<nameOfhotel.size();j++) {
				if ((nameOfhotel.get(j).name).equals(highRatedHotel.get(i).name)) {
					hotelNameVariable.add(highRatedHotel.get(i).name);
					value = rate[j];
				}
			}
		}
		
		return String.join(" & ", hotelNameVariable) + ", Rates: " +value;
	}
	public String BestRatedCheapHotelForRegular(String inputDate){

        String[] inputArr = inputDate.split(",");
        DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");

        ArrayList<LocalDate> dateArr = new ArrayList<>();
        dateArr.add(LocalDate.parse(inputArr[0],fomat));
        long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));

        while(noOfDaysBetween>0) {
            dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
            noOfDaysBetween--;
        }

        Integer[] rate=new Integer[] {0,0,0};
        int total=0;



        dateArr.stream().forEach(n->{
            for(int i=0;i<nameOfhotel.size();i++) {

                if (n.getDayOfWeek().equals(DayOfWeek.SATURDAY) || n.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

                    rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Rewarded).weekendRate;
                    Rate hotelRates=new Rate(nameOfhotel.get(i).name,nameOfhotel.get(i).rating,rate[i]);
                    rates.add(hotelRates);
                }
                else {

                    rate[i] += nameOfhotel.get(i).rates.get(CustomerType.Rewarded).weekdayRate;
                    Rate hotelRates=new Rate(nameOfhotel.get(i).name,nameOfhotel.get(i).rating,rate[i]);
                    rates.add(hotelRates);
                }

            }
        });

	}
	
	public void print() {
		for(int i=0;i<3;i++) {
			System.out.println(nameOfhotel.get(i).rates.get(CustomerType.Regular).weekdayRate);
			System.out.println(nameOfhotel.get(i).rates.get(CustomerType.Regular).weekendRate);
		}
	}

	
}
