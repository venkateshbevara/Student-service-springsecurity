package com.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.controller.StudentController;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceApplicationTests {

	@Autowired
	private StudentService sserve;
	@Autowired
	private StudentController sc;
	@MockBean
	private StudentRepository srepo;
	@Test
	void contextLoads() {
	} 
	
	@Test
	public void getStudentsTest(){
		when(srepo.findAll()).thenReturn(Stream.of(new Student(1,"sachin",22,222,"male"),new Student(2,"Karthik",22,222,"male")).collect(Collectors.toList()));
		String k=sserve.getStudents().get(1).getSname();
		assertEquals(k,"Karthik");
	}
	@Test
	public void getwelcomepageTest() {
		String value=sc.getwelcomepage();
		assertEquals(value,"Welcome");
	}
	
	@Test
	public void getStudentTest() {
		String s1="sachin";
		Student s=new Student(1,"sachin",22,222,"male");
		when(srepo.findBySname(s1)).thenReturn(s);
		assertEquals(1,sserve.getStudent(s1).getSid());
	}
	@Test
	public void getStudentTest2() {
		Optional<Student> s=Optional.of(new Student(1,"sachin",22,222,"male"));
		when(srepo.findById(1)).thenReturn(s);
		assertEquals("sachin",sserve.getStudentid(1).getSname());
	}
	@Test
	public void setStudentTest() {
		Student s1=new Student(21,"male",22,222,"sachin");
		boolean res=sc.setStudent(s1);
		assertTrue(res);
	}
	

}
