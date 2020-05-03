package com.zskm.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String number;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "passport")
	private Student student;
	
	public Passport() {
	}
	

	public Passport(String number) {
		this.number = number;
	}


	public String getName() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}
	
	


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public String getNumber() {
		return number;
	}


	@Override
	public String toString() {
		return "Passport [number=" + number + "]";
	}
	
	
	
}
