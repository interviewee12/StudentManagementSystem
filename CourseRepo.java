package com.SMS.studentmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SMS.studentmanagementsystem.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

	Course getById(int courseId);
    // JpaRepository already provides findAll(), save(), deleteById(), and existsById().

}
