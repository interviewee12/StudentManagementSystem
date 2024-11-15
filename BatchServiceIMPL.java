package com.SMS.studentmanagementsystem.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SMS.studentmanagementsystem.dto.BatchDTO;
import com.SMS.studentmanagementsystem.dto.BatchSaveDTO;
import com.SMS.studentmanagementsystem.dto.BatchUpdateDTO;
import com.SMS.studentmanagementsystem.entity.Batch;
import com.SMS.studentmanagementsystem.repo.BatchRepo;
import com.SMS.studentmanagementsystem.repo.CourseRepo;
import com.SMS.studentmanagementsystem.service.BatchService;

@Service
public class BatchServiceIMPL implements BatchService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) {

        Batch batch = new Batch(
                batchSaveDTO.getBatchName(),
                batchSaveDTO.getStartDate(),
                courseRepo.getById(batchSaveDTO.getCourseId())

        );
        batchRepo.save(batch);
        return batch.getBatchname();
    }

    @Override
    public List<BatchDTO> getAllBatches() {

        List<Batch> getBatches = batchRepo.findAll();
        List<BatchDTO> batchDTOList = new ArrayList<>();
        for(Batch batch:getBatches)
        {
            BatchDTO batchDTO = new BatchDTO(
                    batch.getBatchid(),
                    batch.getBatchname(),
                    batch.getCourse(),
                    batch.getStartdate()
            );
            batchDTOList.add(batchDTO);
        }
        return batchDTOList;

    }

    @Override
    public String updateBatch(BatchUpdateDTO batchUpdateDTO) {

        if(batchRepo.existsById(batchUpdateDTO.getBatchId()))
        {
            Batch batch = batchRepo.getById(batchUpdateDTO.getBatchId());
            batch.setBatchname(batchUpdateDTO.getBatchName());
            batch.setCourse(courseRepo.getById(batchUpdateDTO.getCourseId()));
            batch.setStartdate(batchUpdateDTO.getStartDate());

            batchRepo.save(batch);
            return batch.getBatchname();
        }
        else
        {
            System.out.println("Course ID Not Found");
        }
        return null;
    }

    @Override
    public boolean deleteBatch(int id) {

        if(batchRepo.existsById(id))
        {
            batchRepo.deleteById(id);
        }
        else
        {
            System.out.println("Course ID Not Found");
        }
        return false;

    }
}