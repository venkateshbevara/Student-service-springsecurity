package com.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.entity.MyUserDetails;
import com.student.entity.Student;
import com.student.entity.User;
import com.student.repository.StudentRepository;
import com.student.repository.UserRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService,UserDetailsService {
	@Autowired
    private StudentRepository srepo;
	
	
	
	@Value("${college.url}")
	private String curl;
	public boolean setStudent(Student student) {
		
		srepo.save(student);
		return true;
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
	public Student getStudent(String sname) {
		return srepo.findBySname(sname);
	}
	@Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }
	@Override
	public Student getStudentid(int sid) {
		return srepo.findById(sid).orElse(new Student());
	}

	
}
