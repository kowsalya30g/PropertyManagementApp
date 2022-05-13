package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Maintenance {
	
	
        @Id
		long id ;
		
        @NotBlank(message="complintDescription should not be Blank")
		String complaintDescription;
		
		@NotBlank(message = "Price should be provided")
		double price;
		
		@NotBlank(message="propertyId should not be Blank")
		long propertyId;
		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getComplainDescription() {
			return complaintDescription;
		}

		public void setComplainDescription(String complainDescription) {
			this.complaintDescription = complainDescription;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice( double price) {
			this.price = price;
		}

		public long getPropertyId() {
			return propertyId;
		}

		public void setPropertyId(long propertyId) {
			this.propertyId = propertyId;
		}

		@Override
		public String toString() {
			return "Maintenance [id=" + id + ", complaintDescription=" + complaintDescription + ", price=" + price
					+ ", propertyId=" + propertyId + "]";
		}
}
