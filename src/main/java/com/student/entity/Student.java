package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id	
	private int sid;
	private String sname;
	private int age;
	private int marks;
	private String gender;
	public Student(int sid, String sname, int age, int marks, String gender) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.marks = marks;
		this.gender = gender;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Student() {
		
	}
}
