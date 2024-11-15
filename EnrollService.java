package com.SMS.studentmanagementsystem.service;

import java.util.List;

import com.SMS.studentmanagementsystem.dto.EnrollDTO;
import com.SMS.studentmanagementsystem.dto.EnrollSaveDTO;
import com.SMS.studentmanagementsystem.dto.EnrollUpdateDTO;

public interface EnrollService {
	    String addEnroll(EnrollSaveDTO entrollSaveDTO);

	    List<EnrollDTO> getAllEnroll();

	    String updateEnroll(EnrollUpdateDTO enrollUpdateDTO);

	    boolean deleteEnroll(int id);
	}

