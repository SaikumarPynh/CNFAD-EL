package com.example.StudentManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagementSystem.entity.*;

@Controller
public class StudentController {
	@GetMapping("/students")
	public String home() {
		return "index";
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// created student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // Save the student (you need to implement this logic)
        // For demonstration purposes, let's assume you have a service to save the student
        // studentService.save(student);
        return "redirect:/students"; // Redirect to the student list page
    }
	
}
