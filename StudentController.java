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
import com.SMS.studentmanagementsystem.service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@PostMapping(path = "/save")
	public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO) {
		System.out.println("Request received");
		System.out.println("Student Save " + studentSaveDTO.toString());
		String stname = studentservice.addStudent(studentSaveDTO);

		return stname;
	}

	@GetMapping("/getALLStudents")
	public List<StudentDTO> getALLStudents() {
		List<StudentDTO> allStudents = studentservice.getALLStudents();
		return allStudents;
	}

	@PutMapping(path = "/update")
	public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
		System.out.println("Request received");
		System.out.println("Student Save " + studentUpdateDTO.toString());
		String stname = studentservice.updateStudent(studentUpdateDTO);

		return stname;
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") int id)

	{

		boolean deleteStudent = studentservice.deleteStudent(id);
		return "deletedddd";

	}
}
