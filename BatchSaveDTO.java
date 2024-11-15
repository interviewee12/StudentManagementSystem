package com.SMS.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchSaveDTO {

    private String batchName;

    private int courseId;

    private String startDate;
}