package com.SMS.studentmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id", length = 11)
	private int studentid;

	@Column(name = "student_name", length = 45)
	private String studentname;

	@Column(name = "student_address", length = 60)
	private String address;

	@Column(name = "student_phone", length = 12)
	private String phone;

	public Student() {
		super();

	}

	public Student(int studentid, String studentname, String address, String phone) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.address = address;
		this.phone = phone;
	}

	public Student(String studentname, String address, String phone) {
		super();
		this.studentname = studentname;
		this.address = address;
		this.phone = phone;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", address=" + address + ", phone="
				+ phone + "]";
	}

}
