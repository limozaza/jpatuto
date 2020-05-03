package com.zskm.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	public Course() {}
	public Course(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
