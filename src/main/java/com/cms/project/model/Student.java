package com.cms.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private long stud_id;
	@Column(name= "s_first_name")
	private String stud_Fname;
	@Column(name= "s_last_name")
	private String stud_Lname;
	@Column(name= "s_email",unique=true)
	private String stud_Email;
	@Column(name= "s_mobileno",unique=true)
	private int stud_Mobileno;
	@Column(name= "s_password")
	private String stud_Password;
	private Address address;
	@ManyToOne
	private ClassRoom classRoom;
	
	public Student() {
		
	}
	
	public Student(String stud_Fname, String stud_Lname, String stud_Email, int stud_Mobileno, String stud_Password,
			Address address) {
		super();
		this.stud_Fname = stud_Fname;
		this.stud_Lname = stud_Lname;
		this.stud_Email = stud_Email;
		this.stud_Mobileno = stud_Mobileno;
		this.stud_Password = stud_Password;
		this.address = address;
	}
	public long getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getStud_Fname() {
		return stud_Fname;
	}
	public void setStud_Fname(String stud_Fname) {
		this.stud_Fname = stud_Fname;
	}
	public String getStud_Lname() {
		return stud_Lname;
	}
	public void setStud_Lname(String stud_Lname) {
		this.stud_Lname = stud_Lname;
	}
	public String getStud_Email() {
		return stud_Email;
	}
	public void setStud_Email(String stud_Email) {
		this.stud_Email = stud_Email;
	}
	public int getStud_Mobileno() {
		return stud_Mobileno;
	}
	public void setStud_Mobileno(int stud_Mobileno) {
		this.stud_Mobileno = stud_Mobileno;
	}
	public String getStud_Password() {
		return stud_Password;
	}
	public void setStud_Password(String stud_Password) {
		this.stud_Password = stud_Password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
