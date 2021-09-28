package com.cms.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.project.dto.SubjectDetailResult;
import com.cms.project.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
//	select s.id,sb.subject_name from students s join subjects sb where s.class_room_class_id=sb.classroom_class_id and s.id=?;
		@Query("SELECT new com.cms.project.dto.SubjectDetailResult(s.stud_id,sb.subject_id,sb.subject_name) FROM Student s JOIN s.classRoom c JOIN c.subject sb WHERE s.stud_id=?1")
		public List<SubjectDetailResult> getSubjectById(Long stud_id);
		
//		@Query("from Student where stud_Email=?1")
//		public Student getStudentIdByEmail(String email);
		
//	@Query("SELECT s.stud_id,sb.subject_id,sb.subject_name FROM Student s JOIN Subject sb WHERE s.classRoom=sb.classroom AND s.stud_id=?1")
//	public List<Student> getSubjectById(Long stud_id);
		
		@Query("SELECT c.class_name from Student s JOIN s.classRoom c WHERE s.stud_id=?1")
		public String getClassroomById(Long stud_id);
		
		@Query("from Student order by ?1 desc")
		public List<Student> getStudentByClass(String stud_10thper);
}

