package com.cms.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Subjects")
public class Subject {
	
	@Id
	private String subject_id;
	private String subject_name;
	@ManyToOne()
	private ClassRoom classroom;
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher teacher;
	
	public Subject() {
		
	}

	public ClassRoom getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject(String subject_id, String subject_name, ClassRoom classroom, Teacher teacher) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.classroom = classroom;
		this.teacher = teacher;
	}

	public Subject(String subject_id, String subject_name) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
	}

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	

}
