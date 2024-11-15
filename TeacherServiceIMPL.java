package com.SMS.studentmanagementsystem.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SMS.studentmanagementsystem.dto.StudentSaveDTO;
import com.SMS.studentmanagementsystem.dto.StudentUpdateDTO;
import com.SMS.studentmanagementsystem.dto.TeacherDTO;
import com.SMS.studentmanagementsystem.dto.TeacherSaveDTO;
import com.SMS.studentmanagementsystem.dto.TeacherUpdateDTO;
import com.SMS.studentmanagementsystem.entity.Student;
import com.SMS.studentmanagementsystem.entity.Teacher;
import com.SMS.studentmanagementsystem.repo.TeacherRepo;
import com.SMS.studentmanagementsystem.service.TeacherService;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
    	
        // Convert DTO to Entity
        Teacher teacher = new Teacher(
            teacherSaveDTO.getTeacherName(),
            teacherSaveDTO.getAddress(),
            teacherSaveDTO.getPhone()
        );

        // Save to the repository
        teacherRepo.save(teacher);

        // Return saved teacher name
        return teacher.getTeachername();
    }

    @Override
    public List<TeacherDTO> getALLTeachers() {
        // Get list of all teachers
        List<Teacher> getTeachers = teacherRepo.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        // Convert Teacher entities to TeacherDTO and add to the list
        for (Teacher teacher : getTeachers) {
            TeacherDTO teacherDTO = new TeacherDTO(
                teacher.getTeacherid(),
                teacher.getTeachername(),
                teacher.getAddress(),
                teacher.getPhone()
            );
            teacherDTOList.add(teacherDTO);
        }

        return teacherDTOList;
    }

    
    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        if (teacherRepo.existsById(teacherUpdateDTO.getTeacherId())) {
            Teacher teacher = teacherRepo.getById(teacherUpdateDTO.getTeacherId());
            teacher.setTeachername(teacherUpdateDTO.getTeacherName());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhone(teacherUpdateDTO.getPhone());
            teacherRepo.save(teacher);
            return teacher.getTeachername();
        } else {
            System.out.println("Teacher ID Not Found");
            return "Teacher ID Not Found"; // Return an informative message instead of null
        }
    }

    @Override
    public boolean deleteTeacher(int id) {
        if (teacherRepo.existsById(id)) {
            teacherRepo.deleteById(id);
            return true; // Return true when the teacher is successfully deleted
        } else {
            System.out.println("Teacher ID Not Found");
            return false; // Return false if the teacher does not exist
        }
    }

	
    
	
	
	
	
	
	
	
	
}
