package com.example.StudentManagementSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.entity.Course;
import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    
    public StudentService(StudentRepository studentrepository) {
    	super();
    	this.studentRepository=studentrepository;
    	
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student saveStudent(Student student) {
    	return studentRepository.save(student);
    }
    
    public Student getStudentById(Long id) {
    	return studentRepository.findById(id).get();
    }
    public Student  updateStudent(Student student) {
    	return studentRepository.save(student);
    }
    
    public void deletestudentbyid(Long id) {
    	studentRepository.deleteById(id);
    }
    
}

