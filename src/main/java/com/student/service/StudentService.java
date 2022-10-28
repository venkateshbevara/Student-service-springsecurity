package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;


public interface StudentService {
		boolean setStudent(Student student);
		List<Student> getStudents();
		void deleteStudent(int sid);
		
		Student getStudent(String sname);
		Student getStudentid(int sid);
		
		
}
