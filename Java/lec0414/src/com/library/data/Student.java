package com.library.data;

public class Student {
	int studentNo;
	String name;
	String department;
	int phoneNo;
	
	public Student(int studentNo, String name, String department, int phoneNo) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.department = department;
		this.phoneNo = phoneNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
