package com.SMS.studentmanagementsystem.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="courset_id", length = 11)
	private  int courseid;
	
	
	@Column(name="course_name", length = 45)
	private String coursename;
	
	@Column(name="syllabus", length = 60)
	private String syllabus;
	
	@Column(name="duration", length = 12)
	private String duration;
	
	@OneToMany(mappedBy = "course")
	private Set<Batch> batches;
	
	

	public Course(int courseid, String coursename, String syllabus, String duration) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.syllabus = syllabus;
		this.duration = duration;
	}

	public Course(String coursename, String syllabus, String duration) {
		super();
		this.coursename = coursename;
		this.syllabus = syllabus;
		this.duration = duration;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", syllabus=" + syllabus + ", duration="
				+ duration + "]";
	}
	
   
	
	
	
	
	
}
