package com.adiverse.erp.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="openpdf")
public class OpenPdfModel {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	//private long id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String website;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		if (address!=null) {
			return address;
		}
		else {
			return "";
		}
		
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		if (city!=null) {
			return city;
		}
		else {
			return "";
		}
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		if (state!=null) {
			return state;
		}
		else {
			return "";
		}
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		if (pin!=null) {
			return pin;
		}
		else {
			return "";
		}
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getWebsite() {
		if (website!=null) {
			return website;
		}
		else {
			return "";
		}
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
