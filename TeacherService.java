package com.SMS.studentmanagementsystem.service;

import java.util.List;

import com.SMS.studentmanagementsystem.dto.StudentDTO;
import com.SMS.studentmanagementsystem.dto.TeacherDTO;
import com.SMS.studentmanagementsystem.dto.TeacherSaveDTO;
import com.SMS.studentmanagementsystem.dto.TeacherUpdateDTO;

public interface TeacherService {

	String addTeacher(TeacherSaveDTO teacherSaveDTO);

	List<TeacherDTO> getALLTeachers();

	boolean deleteTeacher(int id);

	String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

		
}
