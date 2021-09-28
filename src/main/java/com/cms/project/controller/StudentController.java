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

import com.cms.project.dto.SubjectDetailResult;
import com.cms.project.exception.ResourceNotFoundException;
import com.cms.project.model.ClassRoom;
import com.cms.project.model.Student;
import com.cms.project.model.Subject;
import com.cms.project.repository.ClassroomRepository;
import com.cms.project.repository.StudentRepository;
import com.cms.project.repository.SubjectRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassroomRepository classroomRepo;
	
	private SubjectRepository subjectRepo;

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
		student.setStud_10thper(studentDetails.getStud_10thper());
		student.setStud_passyear(studentDetails.getStud_passyear());
		
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
	
	
	@GetMapping("/allstudents/subject/{stud_id}")
	public List<SubjectDetailResult> getStudentSubject(@PathVariable Long stud_id) {	
		
		return studentRepository.getSubjectById(stud_id);
	}
	
	@GetMapping("/class/subject/{stud_id}")
	public String getStudentClassroom(@PathVariable Long stud_id) {	
		
		return studentRepository.getClassroomById(stud_id);
	}
	
	@GetMapping("/allstudents/percentsort/{stud_10thper}")
	public List<Student> getStudentbyPercent(String per){
		
		return studentRepository.getStudentByClass(per);
	}
	
//	@GetMapping("/getsubjectid")
//	public Student getStudentId(String email) {	
//		
//		return studentRepository.getStudentIdByEmail(email);
//	}
	
	
	
	
}
