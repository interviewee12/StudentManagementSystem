package com.SMS.studentmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SMS.studentmanagementsystem.entity.Batch;

public interface BatchRepo extends JpaRepository<Batch,Integer> {
	
	}

