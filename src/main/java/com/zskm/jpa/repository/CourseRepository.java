package com.zskm.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zskm.jpa.entity.Course;
import com.zskm.jpa.entity.Review;

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
	
	public Course save(Course course) {
		if(course.getId() == null) {
			this.em.persist(course);
		}else {
			this.em.merge(course);
		}
		return course;
	}
	
	public void addReviewsForCourse(Long idCourse, List<Review> reviews) {
		Course c = findById(idCourse);
		
		for(Review review:reviews) {
			review.setCourse(c);
			em.persist(review);
		}
		
	}
	

}
