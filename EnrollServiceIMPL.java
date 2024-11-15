package com.SMS.studentmanagementsystem.service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SMS.studentmanagementsystem.dto.EnrollDTO;
import com.SMS.studentmanagementsystem.dto.EnrollSaveDTO;
import com.SMS.studentmanagementsystem.dto.EnrollUpdateDTO;
import com.SMS.studentmanagementsystem.entity.Enroll;
import com.SMS.studentmanagementsystem.repo.BatchRepo;
import com.SMS.studentmanagementsystem.repo.EnrollRepo;
import com.SMS.studentmanagementsystem.repo.StudentRepo;
import com.SMS.studentmanagementsystem.service.EnrollService;

@Service
public class EnrollServiceIMPL implements EnrollService {

    @Autowired
    private EnrollRepo enrollRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public String addEnroll(EnrollSaveDTO entrollSaveDTO) {

        Enroll enroll = new Enroll(
                studentRepo.getById(entrollSaveDTO.getStudentId()),
                batchRepo.getById(entrollSaveDTO.getBatchId()),
                entrollSaveDTO.getJoinDate(),
                entrollSaveDTO.getFee()

        );

        enrollRepo.save(enroll);


        return enroll.getJoindate();


    }

    @Override
    public List<EnrollDTO> getAllEnroll() {


        List<Enroll> getEnroll = enrollRepo.findAll();
        List<EnrollDTO> enrollDTOList = new ArrayList<>();
        for(Enroll enroll:getEnroll)
        {
            EnrollDTO enrollDTO = new EnrollDTO(
                    enroll.getEnrollid(),
                    enroll.getStudent(),
                    enroll.getBatch(),
                    enroll.getJoindate(),
                    enroll.getFee()
            );
            enrollDTOList.add(enrollDTO);
        }
        return enrollDTOList;


    }

    @Override
    public String updateEnroll(EnrollUpdateDTO enrollUpdateDTO) {


        if(enrollRepo.existsById(enrollUpdateDTO.getEnrollId()))
        {
            Enroll enroll  = enrollRepo.getById(enrollUpdateDTO.getEnrollId());
            enroll.setStudent(studentRepo.getById(enrollUpdateDTO.getStudentId()));
            enroll.setBatch(batchRepo.getReferenceById(enrollUpdateDTO.getBatchId()));
            enroll.setJoindate(enrollUpdateDTO.getJoinDate());
            enroll.setFee(enrollUpdateDTO.getFee());

            enrollRepo.save(enroll);
            return enroll.getJoindate();
        }
        else
        {
            System.out.println("Enrollment ID Not Found");
        }
        return null;

    }

    @Override
    public boolean deleteEnroll(int id) {

        if(enrollRepo.existsById(id))
        {
            enrollRepo.deleteById(id);
        }
        else
        {
            System.out.println("Enrollment ID Not Found");
        }
        return false;
    }
}