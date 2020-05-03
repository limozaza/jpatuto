package com.zskm.jpa.repository;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zskm.jpa.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	private EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = this.findById(id);
		this.em.remove(course);
	}
	
	

}
