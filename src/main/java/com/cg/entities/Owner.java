package com.cg.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Owner")
@DiscriminatorValue("owner")
public class Owner extends Person{
	
	@NotBlank(message="saleOrRent should be mentioned")
	@Column(name="saleOrRent")
	private String saleOrRent;

    @OneToMany(targetEntity = Property.class,cascade = CascadeType.ALL , mappedBy = "owner")
    //@JsonManagedReference
    @JsonIgnore
	private List<Property> property ;
	
	public Owner() {
		super();
	}

	
/*      public Owner(String personName, int age, String email, String dateOfBirth, Address address,boolean saleOrRent) {
	    super(personName, age, email, dateOfBirth);
		//	super(personName, age, email, dateOfBirth, address);
		this.saleOrRent=saleOrRent;
		// TODO Auto-generated constructor stub
	    }

*/

	public String isSaleOrRent() {
		return saleOrRent;
	}

	public List<Property> getProperty() {
		return property;
	}


	public void setProperty(List<Property> property) {
		this.property = property;
	}


	public String getSaleOrRent() {
		return saleOrRent;
	}


	public void setSaleOrRent(String saleOrRent) {
		this.saleOrRent = saleOrRent;
	}

	@Override
	public String toString() {
		return "Owner [ , saleOrRent=" + saleOrRent + "]";
	}
	
	

}
