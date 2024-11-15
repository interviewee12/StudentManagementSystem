package com.SMS.studentmanagementsystem.service;

import java.util.List;

import com.SMS.studentmanagementsystem.dto.BatchDTO;
import com.SMS.studentmanagementsystem.dto.BatchSaveDTO;
import com.SMS.studentmanagementsystem.dto.BatchUpdateDTO;

public interface BatchService {
	
	    String addBatch(BatchSaveDTO batchSaveDTO);

	    List<BatchDTO> getAllBatches();

	    String updateBatch(BatchUpdateDTO batchUpdateDTO);

	    boolean deleteBatch(int id);
	}

