package com.example.demo;

import com.example.demo.entity.Student;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	// this is a just comment from Student Dummy


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
