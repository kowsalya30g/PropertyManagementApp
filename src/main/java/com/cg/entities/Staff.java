package com.cg.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Person{
	

	@NotBlank(message="Department cannot be NULL")
	private String department;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(  name="staffServices", joinColumns=@JoinColumn(name="staffId") )
	private List<String> services;
	
	@NotNull(message="Availability cannot be NULL")
	private boolean isAvailable;
	
	public Staff() {}



	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public List<String> getServices() {
		return services;
	}
	
	public void setServices(List<String> services) {
		this.services = services;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Staff [department=" + department + ", services=" + services + ", isAvailable=" + isAvailable + "]";
	}
		

}
