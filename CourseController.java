package com.SMS.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SMS.studentmanagementsystem.dto.CourseDTO;
import com.SMS.studentmanagementsystem.dto.CourseSaveDTO;
import com.SMS.studentmanagementsystem.dto.CourseUpdateDTO;
import com.SMS.studentmanagementsystem.dto.StudentDTO;
import com.SMS.studentmanagementsystem.dto.StudentSaveDTO;
import com.SMS.studentmanagementsystem.dto.StudentUpdateDTO;
import com.SMS.studentmanagementsystem.service.CourseService;
import com.SMS.studentmanagementsystem.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {
   
	@Autowired
	private CourseService courseservice;
	
	
	@PostMapping (path = "/save")
	public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO)
	{
		System.out.println("Request received");
		System.out.println("Course Save "+courseSaveDTO.toString());
		String course = courseservice.addCourse(courseSaveDTO);
		
		return course;
	}
	
	
	@GetMapping("/getAllCourses")
	public List<CourseDTO> getALLCourses(){
		List<CourseDTO> allCourses = courseservice.getAllCourses();
		return allCourses;
	}
	
	
	@PutMapping (path = "/update")
	public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO)
	{
		System.out.println("Request received");
		System.out.println("Course Save "+courseUpdateDTO.toString());
		String course = courseservice.updateCourse(courseUpdateDTO);
		
		return course;
	}


	@DeleteMapping (path = "/delete/{id}")
	public String deleteCourse(@PathVariable(value = "id")int id)

	{
		
	 boolean deleteCourse = courseservice.deleteCourse(id);
	 return "deletedddd";

	}
	}





	

