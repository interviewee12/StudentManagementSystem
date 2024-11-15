package com.SMS.studentmanagementsystem.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SMS.studentmanagementsystem.dto.CourseDTO;
import com.SMS.studentmanagementsystem.dto.StudentDTO;
import com.SMS.studentmanagementsystem.dto.StudentSaveDTO;
import com.SMS.studentmanagementsystem.dto.StudentUpdateDTO;
import com.SMS.studentmanagementsystem.entity.Course;
import com.SMS.studentmanagementsystem.entity.Student;
import com.SMS.studentmanagementsystem.repo.StudentRepo;
import com.SMS.studentmanagementsystem.service.StudentService;

@Service

public class StudentServiceIMPL implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public String addStudent(StudentSaveDTO studentSaveDTO) {

		Student student = new Student(

				studentSaveDTO.getStudentName(), studentSaveDTO.getAddress(), studentSaveDTO.getPhone()

		);

		studentRepo.save(student);

		return student.getStudentname();
	}

	@Override
	public List<StudentDTO> getALLStudents() { // Ensure the name matches
		// Get list of all courses
		List<Student> getStudents = studentRepo.findAll();
		List<StudentDTO> studentDTOList = new ArrayList<>();

		for (Student student : getStudents) {
			StudentDTO studentDTO = new StudentDTO(student.getStudentid(), student.getStudentname(),
					student.getAddress(), student.getPhone());
			studentDTOList.add(studentDTO);
		}

		return studentDTOList;
	}

	@Override
	public String updateStudent(StudentUpdateDTO studentUpdateDTO) {

		if (studentRepo.existsById(studentUpdateDTO.getStudentId()))

		{
			Student student = studentRepo.getById(studentUpdateDTO.getStudentId());
			student.setStudentname(studentUpdateDTO.getStudentName());
			student.setAddress(studentUpdateDTO.getAddress());
			student.setPhone(studentUpdateDTO.getPhone());
			studentRepo.save(student);
			return student.getStudentname();

		} else {
			System.out.println("Student ID Not Found");
		}
		return null;
	}

	@Override
	public boolean deleteStudent(int id) {

		if (studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
		} else {
			System.out.println("Student ID Not Found");
		}

		return false;
	}

}
