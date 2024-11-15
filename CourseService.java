package com.SMS.studentmanagementsystem.service;

import java.util.List;

import com.SMS.studentmanagementsystem.dto.CourseDTO;
import com.SMS.studentmanagementsystem.dto.CourseSaveDTO;
import com.SMS.studentmanagementsystem.dto.CourseUpdateDTO;

public interface CourseService {

    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourses();

    String updateCourse(CourseUpdateDTO courseUpdateDTO);

    boolean deleteCourse(int id);
}
