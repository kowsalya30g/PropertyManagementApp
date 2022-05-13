package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long addressId;
	
	@Column(name="houseNumber")
	private String houseNumber;
	
	@NotBlank(message="city should not be blank")
	@Column(name="city")
	private String city;
	
	@NotBlank(message="state should not be blank")
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	
	public Address() {
		super();
	}
	public Address(String houseNumber, String city, String state, String country) {
		super();
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNumber=" + houseNumber + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}
	
	

}
