package com.example.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagementSystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
