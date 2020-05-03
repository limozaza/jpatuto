package com.zskm.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zskm.jpa.entity.Course;
import com.zskm.jpa.entity.Passport;
import com.zskm.jpa.entity.Student;
import com.zskm.jpa.repository.CourseRepository;
import com.zskm.jpa.repository.StudentRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	private Logger Logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EntityManager em;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Course courseById = this.courseRepository.findById(100L);
		Logger.info("100 -> {}",courseById);
		
		this.courseRepository.deleteById(100L);
		
		this.courseRepository.save(new Course("JPA-03"));
		
		Query query = this.em.createNamedQuery("query_all_courses");
		List<Course> resultList = query.getResultList();
		
		Logger.info("Array -> {}",resultList);
		
		studentRepository.saveStudentWithPassport();
		
		//Trouver un student
		Student student = this.em.find(Student.class, 1000l);
		Logger.info("Student -> {}",student);
		
		
		Passport passport = this.em.find(Passport.class, 10001l);
		
		Logger.info("Passport -> {}",passport.getStudent().getName());
		
		
	}
	

}
