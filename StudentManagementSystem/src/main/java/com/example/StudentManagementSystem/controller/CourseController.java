package com.example.StudentManagementSystem.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagementSystem.entity.*;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.CourseService;

@Controller
public class CourseController {

	private CourseService courseservice;

	public CourseController(CourseService courseservice) {
		super();
		this.courseservice = courseservice;
	}
	
	@GetMapping("/courses")
	public String listcourse(Model model) {
		model.addAttribute("courses",courseservice.getAllCourse() );
		return "courses";
	}
	
	@GetMapping("/courses/new")
	public String createStudentForm(Model model) {
		Course c=new Course();
		model.addAttribute("course",c);
		return "create_course";
	}
	
	@PostMapping("/courses")
	public String saveCourse(@ModelAttribute("course") Course course) {
		courseservice.saveCourse(course);
		return "redirect:/courses";  //means redirect again to /students link after submitting
	}
}
