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

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentManagementSystemApplication(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentManagementSystemApplication.class, args);
        StudentManagementSystemApplication app = context.getBean(StudentManagementSystemApplication.class);
        app.run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter the course details and Student Details");
                System.out.println("Enter the course name");
                String cname = sc.next();
                courseService.addCourse(cname);
                System.out.println("Enter the Student details");
                System.out.println("Enter Student FirstName");
                String fname = sc.next();
                System.out.println("Enter Student LastName");
                String lname = sc.next();
                System.out.println("Enter Student USN");
                String usn = sc.next();
                System.out.println("Enter Student Section");
                String section = sc.next();
                System.out.println("Enter Student email");
                String email = sc.next();
                studentService.addStudent(fname, lname, usn, section, email, courseService.getAllCourse().get(0)); // Assuming the first course is the one just added
            }
        } finally {
            sc.close();
        }
    }
}
