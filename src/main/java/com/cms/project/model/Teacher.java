package com.cms.project.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Teachers")
public class Teacher {
	
	@Id
	private String teacher_id;
	private String teacher_Fname;
	private String teacher_Lname;
	@OneToMany
	private List<Subject> subject;
	public Teacher() {
		
	}

	public Teacher(String teacher_id, String teacher_Fname, String teacher_Lname) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_Fname = teacher_Fname;
		this.teacher_Lname = teacher_Lname;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public Teacher(String teacher_id, String teacher_Fname, String teacher_Lname, List<Subject> subject) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_Fname = teacher_Fname;
		this.teacher_Lname = teacher_Lname;
		this.subject = subject;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_Fname() {
		return teacher_Fname;
	}

	public void setTeacher_Fname(String teacher_Fname) {
		this.teacher_Fname = teacher_Fname;
	}

	public String getTeacher_Lname() {
		return teacher_Lname;
	}

	public void setTeacher_Lname(String teacher_Lname) {
		this.teacher_Lname = teacher_Lname;
	}
	
	
}
