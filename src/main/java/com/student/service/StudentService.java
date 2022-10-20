package com.student.service;

import java.util.List;

import com.student.entity.Student;


public interface StudentService {
		void setStudent(Student student);
		List<Student> getStudents();
		void deleteStudent(int sid);
		Student getStudent(int sid);
		
}
