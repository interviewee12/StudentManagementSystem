package com.SMS.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollUpdateDTO {

    private int enrollId;
    private int studentId;
    private int batchId;
    private String joinDate;
    private int fee;
}