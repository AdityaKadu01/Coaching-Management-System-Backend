package com.cms.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cms.project.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String>{
	@Query("SELECT s.stud_id,sb.subject_id,sb.subject_name FROM Student s JOIN Subject sb WHERE s.classRoom=sb.classroom AND s.stud_id=?1")
	public List<Subject> getSubjectById(Long stud_id);
}
