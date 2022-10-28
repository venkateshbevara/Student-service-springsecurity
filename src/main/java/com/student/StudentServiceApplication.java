package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.student.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class StudentServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRest() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}
