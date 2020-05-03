package com.zskm.jpa.repository;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zskm.jpa.entity.Passport;
import com.zskm.jpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	private EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student Student = this.findById(id);
		this.em.remove(Student);
	}
	
	public Student save(Student Student) {
		if(Student.getId() == null) {
			this.em.persist(Student);
		}else {
			this.em.merge(Student);
		}
		return Student;
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		Student student   = new Student("Adil");
		student.setPassport(passport);
		this.em.persist(passport);
		this.em.persist(student);
	}
	

}
