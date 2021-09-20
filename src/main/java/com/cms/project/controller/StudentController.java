package com.cms.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.project.model.Student;
import com.cms.project.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/allstudents")       // to get all student data
	public List<Student> getAllStudents() {
		return studentRepository.findAll(); // send all student data as response
	}
	
	
	@PostMapping("/addstudent") // to create employee rest api for creating new student
	public Student createStudent(@RequestBody Student student) {	//post send data thro
		return studentRepository.save(student);
	}
}
