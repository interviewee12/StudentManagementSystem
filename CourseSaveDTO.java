package com.SMS.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 

public class CourseSaveDTO {
	
    private String courseName; // Make sure these fields are defined
    private String Syllabus;
    private String Duration;
}
