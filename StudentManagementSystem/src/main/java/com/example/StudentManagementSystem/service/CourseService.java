package com.example.StudentManagementSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.entity.Course;
import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.repository.CourseRepository;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class CourseService {
//
//	@Autowired
//	private CourseRepository cr;
//
//    public void addCourse(String cname) {
//        Course c=new Course();
//        c.setName(cname);
//        cr.save(c);
//        
//    }
//
//    public List<Course> getAllCourse() {
//        return cr.findAll();
//    }
	
	private CourseRepository courserepository;

	public CourseService(CourseRepository courserepository) {
		super();
		this.courserepository = courserepository;
	}
	
	public List<Course> getAllCourse(){
		return courserepository.findAll();
	}
	
    public Course saveCourse(Course course) {
    	return courserepository.save(course);
    }
	
}
