package services;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.*;

// Type your code
public class FareCalculator extends Booking{
	public double book(Hotel hotel) {
		LocalDate from = hotel.getFromdate();
		LocalDate to = hotel.getTodate();
		long daysBetween = ChronoUnit.DAYS.between(from, to);
		double finalRate = 0;
		int noOfPersons = hotel.getNoOfPersons();
		int rate = hotel.getRates();
		if (from.isAfter(to)) {
			return finalRate;
		}
		if (hotel.getOccupancy() == "single") {
			finalRate = super.booking(noOfPersons, rate);
		} else {
			int rooms = (noOfPersons / 2) + (noOfPersons % 2);
			finalRate = super.booking(rooms, rate);
		}
		return finalRate;
		
	}
	public double book(Flight flight) {
		double finalRate = 0;
		int noOfPersons = flight.getNoOfPersons();
		int rate = flight.getRates();
		if (flight.getTriptype() == "two-way") {
			LocalDate from = flight.getFrom();
			LocalDate to = flight.getTo();
			if (from.isAfter(to)) {
				return finalRate;
			}
			else {
				finalRate = 2 * super.booking(noOfPersons, rate);
			}
		} else {
			finalRate = super.booking(noOfPersons, rate);
		}
		return finalRate;
		
	}
	public double book(Train train) {
		int noOfPersons = train.getNoOfPersons();
		int rate = train.getRates();
		double finalRate = (double)super.booking(noOfPersons, rate);
		return finalRate;
		
	}
	public double book(Bus bus) {
		int noOfPersons = bus.getNoOfPersons();
		int rate = bus.getRates();
		double finalRate = (double)super.booking(noOfPersons, rate);
		return finalRate;
	}

}