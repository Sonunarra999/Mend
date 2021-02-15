package com.mend.senatorsinfo.model;

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String postal;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	
	@Override
	public String toString() {
		return "\"street\":" + "\"" + street + "\"" + ", \"city\":" + "\"" + city + "\"" + ", \"state\":" + "\"" + state + "\"" + ", \"postal\":" + "\"" + postal + "\"" ;
	}
	
	
	

}
