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

import com.SMS.studentmanagementsystem.dto.StudentDTO;
import com.SMS.studentmanagementsystem.dto.StudentSaveDTO;
import com.SMS.studentmanagementsystem.dto.StudentUpdateDTO;
import com.SMS.studentmanagementsystem.dto.TeacherDTO;
import com.SMS.studentmanagementsystem.dto.TeacherSaveDTO;
import com.SMS.studentmanagementsystem.dto.TeacherUpdateDTO;
import com.SMS.studentmanagementsystem.service.StudentService;
import com.SMS.studentmanagementsystem.service.TeacherService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {
	
	
	
	@Autowired
	private TeacherService teacherservice;
	
	@Autowired
	private StudentService studentservice;
	
	
	
	
  @PostMapping (path = "/save")
	public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
	{
		System.out.println("Request received");
		System.out.println("Teacher Save "+teacherSaveDTO.toString());
		String teachername = teacherservice.addTeacher(teacherSaveDTO);
		
		return teachername;
	}
	
	
	@GetMapping("/getALLTeachers")
	public List<TeacherDTO> getALLTeachers(){
		List<TeacherDTO> allTeachers = teacherservice.getALLTeachers();
		return allTeachers;
	}
	
	

 @PutMapping (path = "/update")
public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO)
{
	System.out.println("Request received");
	System.out.println("Teacher Save "+teacherUpdateDTO.toString());
	String teachername = teacherservice.updateTeacher(teacherUpdateDTO);
	
	return teachername;
}


@DeleteMapping (path = "/delete/{id}")
public String deleteTeacher(@PathVariable(value = "id")int id)

{
	
 boolean deleteTeacher = teacherservice.deleteTeacher(id);
 return "deletedddd";

}

}
