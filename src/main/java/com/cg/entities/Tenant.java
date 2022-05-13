package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Tenant")
@DiscriminatorValue("tenant")
public class Tenant extends Person{

	@Column(name="minimumBudget")
	private double minimumBudget;
	
	
	@Column(name="maximumBudget")
	private double maximumBudget;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Property property;
	
	
	public Tenant() {
		super();
	}

     
	public double getMinimumBudget() {
		return minimumBudget;
	}

	

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public void setMinimumBudget(double minimumBudget) {
		this.minimumBudget = minimumBudget;
	}

	public double getMaximumBudget() {
		return maximumBudget;
	}

	public void setMaximumBudget(double maximumBudget) {
		this.maximumBudget = maximumBudget;
	}

	@Override
	public String toString() {
		
		return "Tenant [minimumBudget=" + minimumBudget + ", maximumBudget=" + maximumBudget + "]";
	}



	}
	

