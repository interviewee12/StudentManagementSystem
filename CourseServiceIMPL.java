package com.SMS.studentmanagementsystem.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SMS.studentmanagementsystem.dto.CourseDTO;
import com.SMS.studentmanagementsystem.dto.CourseSaveDTO;
import com.SMS.studentmanagementsystem.dto.CourseUpdateDTO;
import com.SMS.studentmanagementsystem.entity.Course;
import com.SMS.studentmanagementsystem.repo.CourseRepo;
import com.SMS.studentmanagementsystem.service.CourseService;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        // Convert DTO to Entity
        Course course = new Course(
            courseSaveDTO.getCourseName(),
            courseSaveDTO.getSyllabus(),
            courseSaveDTO.getDuration()
        );

        // Save to the repository
        courseRepo.save(course);

        // Return saved course name
        return course.getCoursename();
    }

    @Override
    public List<CourseDTO> getAllCourses() { // Ensure the name matches
        // Get list of all courses
        List<Course> getCourses = courseRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        // Convert Course entities to CourseDTO and add to the list
        for (Course course : getCourses) {
            CourseDTO courseDTO = new CourseDTO(
                course.getCourseid(),
                course.getCoursename(),
                course.getSyllabus(),
                course.getDuration()
            );
            courseDTOList.add(courseDTO);
        }

        return courseDTOList;
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
        return courseRepo.findById(courseUpdateDTO.getCourseId()).map(course -> {
            course.setCoursename(courseUpdateDTO.getCourseName());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            course.setDuration(courseUpdateDTO.getDuration());
            courseRepo.save(course);
            return course.getCoursename();
        }).orElse("Course ID Not Found");
    }

    @Override
    public boolean deleteCourse(int id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return true; // Return true when the course is successfully deleted
        } else {
            System.out.println("Course ID Not Found");
            return false; // Return false if the course does not exist
        }
    }
}
