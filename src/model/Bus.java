package model;

import java.time.LocalDate;

// Type your code
public class Bus {
	public Bus(int noOfPersons, String busType, int rates, LocalDate date) {
		super();
		this.noOfPersons = noOfPersons;
		this.busType = busType;
		this.rates = rates;
		this.date = date;
	}
	private int noOfPersons;
	private String busType;
	private int rates;
	private LocalDate date;
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public int getRates() {
		return rates;
	}
	public void setRates(int rates) {
		this.rates = rates;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
