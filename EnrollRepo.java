package com.SMS.studentmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SMS.studentmanagementsystem.entity.Enroll;

public interface EnrollRepo extends JpaRepository<Enroll,Integer> {
	}

