package com.cg.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PersonType",discriminatorType = DiscriminatorType.STRING)
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long personId;
	
	@NotBlank
	@Column(name="personName")
	@Size(min=2,message="Name should not be blank")
	private String personName;
	
	@Column(name="age")
	private int age;
	@Email(message="email is not in correct format")
	@NotBlank(message="Email should not be blank")
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private Address address;

	public Person() {
		super();
	}

	public Person(String personName, int age, String email, Date dateOfBirth , Address address) {
		super();
		this.personName = personName;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}
	
}
