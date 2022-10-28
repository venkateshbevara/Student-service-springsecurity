package com.student.controller;

import java.util.List;
import java.util.Optional;

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
	public boolean setStudent(@RequestBody Student student) {
	return	studentService.setStudent(student);
	}
	@RequestMapping(method=RequestMethod.GET,value="/welcome")
	public String getwelcomepage() {
		return "Welcome";
	}
	@RequestMapping(method=RequestMethod.GET,value="/getstudents")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/deletestudents/{sid}")
	public void deleteStudent(@PathVariable int sid) {
		 studentService.deleteStudent(sid);
	}
	@RequestMapping(method=RequestMethod.GET,value="/getstudentbysname/{sname}")
	public Student getbysname(@PathVariable String sname) {
			return studentService.getStudent(sname);
	}
	@RequestMapping(method=RequestMethod.GET,value="/getstudentbysid/{sid}")
	public Student getbyid(@PathVariable int sid) {
			return studentService.getStudentid(sid);
	}
	
}
