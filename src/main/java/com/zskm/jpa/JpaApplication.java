package com.zskm.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zskm.jpa.entity.Course;
import com.zskm.jpa.repository.CourseRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	private Logger Logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Course courseById = this.courseRepository.findById(100L);
		Logger.info("100 -> {}",courseById);
		
		this.courseRepository.deleteById(100L);
		
		this.courseRepository.save(new Course("JPA-03"));
	}
	

}
