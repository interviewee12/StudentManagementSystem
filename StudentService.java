package com.SMS.studentmanagementsystem.service;

import java.util.List;

import com.SMS.studentmanagementsystem.dto.StudentDTO;
import com.SMS.studentmanagementsystem.dto.StudentSaveDTO;
import com.SMS.studentmanagementsystem.dto.StudentUpdateDTO;

public interface StudentService {

	String addStudent(StudentSaveDTO studentSaveDTO);

	String updateStudent(StudentUpdateDTO studentUpdateDTO);

	boolean deleteStudent(int id);

	List<StudentDTO> getALLStudents();

}
