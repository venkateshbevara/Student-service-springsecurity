package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired	
	private StudentService studentService;
	@RequestMapping(method=RequestMethod.POST,value="/setstudent")
	public void setStudent(@RequestBody Student student) {
		studentService.setStudent(student);
	}
	@RequestMapping(method=RequestMethod.GET,value="/getstudents")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	@RequestMapping(method=RequestMethod.GET,value="/deletestudents/{sid}")
	public void deleteStudent(@PathVariable int sid) {
		 studentService.deleteStudent(sid);
	}
	@RequestMapping(method=RequestMethod.GET,value="/getstudentbyid/{sid}")
	public Student getbyid(@PathVariable int sid) {
			return studentService.getStudent(sid);
	}
	
}
