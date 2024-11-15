package com.SMS.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseUpdateDTO {
	
    private int courseId; 
    private String courseName;
    private String syllabus;
    private String duration;
}
