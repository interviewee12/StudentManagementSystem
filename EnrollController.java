package com.SMS.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SMS.studentmanagementsystem.dto.EnrollDTO;
import com.SMS.studentmanagementsystem.dto.EnrollSaveDTO;
import com.SMS.studentmanagementsystem.dto.EnrollUpdateDTO;
import com.SMS.studentmanagementsystem.service.EnrollService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enroll")
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    @PostMapping(path = "/save")
    public String saveEnroll(@RequestBody EnrollSaveDTO entrollSaveDTO)
    {
        String enroll = enrollService.addEnroll(entrollSaveDTO);
        return "enrollment addedd";
    }

    @GetMapping("/getAllEnrolls")
    public List<EnrollDTO> getAllEnrolls()
    {
        List<EnrollDTO> allEnroll = enrollService.getAllEnroll();
        return getAllEnrolls();
    }

    @PutMapping(path = "/update")
    public String updateEnrollment(@RequestBody EnrollUpdateDTO enrollUpdateDTO)
    {
        String enroll = enrollService.updateEnroll(enrollUpdateDTO);
        return enroll;

    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnrollment(@PathVariable(value = "id")int id)
    {
        boolean deleteCourse = enrollService.deleteEnroll(id);
        return "deletedddddd!!!!";

    }

}