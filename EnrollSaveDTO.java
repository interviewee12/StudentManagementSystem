package com.SMS.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollSaveDTO {


    private int studentId;
    private int batchId;
    private String joinDate;
    private int fee;
}