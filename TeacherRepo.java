package com.SMS.studentmanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SMS.studentmanagementsystem.entity.Student;
import com.SMS.studentmanagementsystem.entity.Teacher;

public interface TeacherRepo  extends JpaRepository<Teacher,Integer>  {

	 // save(Teacher teacher);


	List<Teacher> findAll();

}
