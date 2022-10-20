package com.student.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentRepository srepo;
	
	
	
	@Value("${college.url}")
	private String curl;
	public void setStudent(Student student) {
		
		srepo.save(student);
	}
    @Override
	public List<Student> getStudents() {
		
		return (List<Student>) srepo.findAll();
	}
	@Override
	public void deleteStudent(int sid) {
		// TODO Auto-generated method stub
		 srepo.deleteById(sid);
	}
	@Override
	public Student getStudent(int sid) {
		
		return srepo.findById(sid).get();
	}

	
}
