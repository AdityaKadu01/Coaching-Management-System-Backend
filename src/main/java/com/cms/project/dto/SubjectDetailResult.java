package com.cms.project.dto;

public class SubjectDetailResult {

	private long stud_id;
	private String subject_id;
	private String subject_name;
	
	public SubjectDetailResult() {
		
	}

	public SubjectDetailResult(long stud_id, String subject_id, String subject_name) {
		super();
		this.stud_id = stud_id;
		this.subject_id = subject_id;
		this.subject_name = subject_name;
	}

	public long getStud_id() {
		return stud_id;
	}

	public void setStud_id(long stud_id) {
		this.stud_id = stud_id;
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
