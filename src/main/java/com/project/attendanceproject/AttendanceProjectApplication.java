package com.project.attendanceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AttendanceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceProjectApplication.class, args);
	}

}
