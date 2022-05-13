package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Preference {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long     preferenceId ;
	
	@NotBlank(message="sizeOfApartment should be mentioned")
	private int      sizeOfApartment ;
	
	@NotBlank(message="socialInfrastructure should be mentioned")
	private String   socialInfrastructure ;
	
	@NotBlank(message="constructionQuality should be mentioned")
	private String   constructionQuality ;

	
	public Preference() {}
	
	
	
	public long getPreferenceId() {
		return preferenceId;
	}
	
	public void setPreferenceId(long preferenceId) {
		this.preferenceId = preferenceId;
	}
	
	public int getSizeOfApartment() {
		return sizeOfApartment;
	}
	
	public void setSizeOfApartment(int sizeOfApartment) {
		this.sizeOfApartment = sizeOfApartment;
	}
	
	public String getSocialInfrastructure() {
		return socialInfrastructure;
	}
	
	public void setSocialInfrastructure(String socialInfrastructure) {
		this.socialInfrastructure = socialInfrastructure;
	}
	
	public String getConstructionQuality() {
		return constructionQuality;
	}
	
	public void setConstructionQuality(String constructionQuality) {
		this.constructionQuality = constructionQuality;
	}
	
	
	@Override
	public String toString() {
		return "Preferences [preferenceId=" + preferenceId + ", sizeOfApartment=" + sizeOfApartment
				+ ", socialInfrastructure=" + socialInfrastructure + ", constructionQuality=" + constructionQuality
				+ "]";
	}
	

}
