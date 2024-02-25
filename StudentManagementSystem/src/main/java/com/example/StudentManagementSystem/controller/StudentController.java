package com.example.StudentManagementSystem.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagementSystem.entity.*;
import com.example.StudentManagementSystem.repository.StudentRepository;
import com.example.StudentManagementSystem.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentservice;
//	@GetMapping("/students")
//	public String home() {
//		return "index";
//	}
//	@GetMapping("/students/new")
//	public String createStudentForm(Model model) {
//
//		// created student object to hold student form data
//		Student student = new Student();
//		model.addAttribute("student", student);
//		return "create_student";
//	}
//	@PostMapping("/students")
//    public String saveStudent(@ModelAttribute("student") Student student) {
//        // Save the student (you need to implement this logic)
//        // For demonstration purposes, let's assume you have a service to save the student
//        // studentService.save(student);
//        return "redirect:/students"; // Redirect to the student list page
//    }
	
//	====================================================
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	
	@GetMapping("/students")
	public String liststudents(Model model) {
		model.addAttribute("students",studentservice.getAllStudents() );
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student s=new Student();
		model.addAttribute("student",s);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";  //means redirect again to /students link after submitting
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentservice.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		
		//get student from database
		Student existing=studentservice.getStudentById(id);
		existing.setId(id);
		existing.setFirstname(student.getFirstname());
		existing.setLastname(student.getLastname());
		existing.setUsn(student.getUsn());
		existing.setSection(student.getSection());
		existing.setEmail(student.getEmail());
		existing.setCourse(student.getCourse());
		
		studentservice.updateStudent(existing);
		return "redirect:/students";
		
	}
	
	//handler method to handel delete request
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentservice.deletestudentbyid(id);
		return "redirect:/students";
	}
	
	
}

