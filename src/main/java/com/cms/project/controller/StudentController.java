package com.cms.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.project.exception.ResourceNotFoundException;
import com.cms.project.model.Student;
import com.cms.project.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/allstudents")       // to get all student data
	public List<Student> getAllStudents() {
		return studentRepository.findAll(); // send all student data as response
	}
	
	
	@PostMapping("/allstudents") // to create employee rest api for creating new student
	public Student createStudent(@RequestBody Student student) {	
		return studentRepository.save(student);
	}
	
	@GetMapping("/allstudents/{stud_id}") // to find student rest api 
	public ResponseEntity<Student> getStudentById(@PathVariable Long stud_id) {
		Student student =studentRepository.findById(stud_id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : "+ stud_id));
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/allstudents/{stud_id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long stud_id,@RequestBody Student studentDetails) {
		Student student =studentRepository.findById(stud_id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id : "+ stud_id));
		
		student.setStud_Fname(studentDetails.getStud_Fname());
		student.setStud_Lname(studentDetails.getStud_Lname());
		student.setStud_Email(studentDetails.getStud_Email());
		student.setStud_Mobileno(studentDetails.getStud_Mobileno());
		student.setStud_Password(studentDetails.getStud_Password());
		student.setAddress(studentDetails.getAddress());
		
		Student studentUpdated = studentRepository.save(student);
		return ResponseEntity.ok(studentUpdated);
	}
	
	@DeleteMapping("/allstudents/{stud_id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long stud_id){
		Student student = studentRepository.findById(stud_id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + stud_id));
	
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
