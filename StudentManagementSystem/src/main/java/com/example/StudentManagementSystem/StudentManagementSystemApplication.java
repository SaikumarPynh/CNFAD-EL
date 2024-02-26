package com.example.StudentManagementSystem;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.StudentManagementSystem.service.CourseService;
import com.example.StudentManagementSystem.service.StudentService;

@SpringBootApplication
public class StudentManagementSystemApplication {

    
	public static void main(String args[]) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);	}
}
