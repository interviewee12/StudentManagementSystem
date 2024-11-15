package com.SMS.studentmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentUpdateDTO {

	private int studentId;

	private String studentName;

	private String address;

	private String phone;

	
	}


