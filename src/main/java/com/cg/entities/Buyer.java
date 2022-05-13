package com.cg.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("buyer")
public class Buyer extends Person{
	
	@Min(value=0,message="must be greaterthan zero")
	@Column
	private double      minimumPrice;
	
	@NotNull
	@Column
	private double      maximumPrice;
	
	@Column
	private LocalDate   appointmentDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Property property;
	
	@Column
	private LocalTime   appointmentTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Preference preferences;

	
	
	
	public double getMinimumPrice() {
		return minimumPrice;
	}
	
	public void setMinimumPrice(double minPrice) {
		this.minimumPrice = minPrice;
	}
	
	public double getMaximumPrice() {
		return maximumPrice;
	}
	
	public void setMaximumPrice(double maxPrice) {
		this.maximumPrice = maxPrice;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public Preference getPreferences() {
		return preferences;
	}
	
	public void setPreferences(Preference preferences) {
		this.preferences = preferences;
	}
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		
		return "Buyer [minimumPrice=" + minimumPrice + ", maximumPrice=" + maximumPrice + ", appointmentDate=" + appointmentDate
				+ ", property=" + property + ", appointmentTime=" + appointmentTime + ", preferences=" + preferences
				+ "]";
		
	}

	
}