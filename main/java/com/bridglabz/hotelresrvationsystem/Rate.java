package com.bridglabz.hotelresrvationsystem;

public class Rate implements Comparable {
	
	Integer weekendRate;
	Integer weekdayRate;
	
	
	public Rate(Integer weekendRate, Integer weekdayRate) {
		super();
		this.weekendRate = weekendRate;
		this.weekdayRate = weekdayRate;
	}


	public Integer getWeekendRate() {
		return weekendRate;
	}



	public Integer getWeekdayRate() {
		return weekdayRate;
	}


	@Override
	public int compareTo(Object o) {
		Rate otherObject = (Rate) o;
		return this.weekdayRate.compareTo(otherObject.getWeekdayRate());
		//return this.weekendRate.compareTo(otherObject.getWeekendRate());
	}
}
