package com.cms.project.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ClassRooms")
public class ClassRoom {
	
	@Id
	private String class_id;
	private String class_name;
	@OneToMany(mappedBy = "classRoom")
	private List<Student> student;
	@ManyToMany
	private List<Subject> subject;
	
	public ClassRoom() {
		
	}

	public ClassRoom(String class_id, String class_name) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	
}
