package com.revent.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String subject;
	private Double marks;
	
	public StudentData() {
		// TODO Auto-generated constructor stub
	}

	public StudentData(String name, String subject, Double marks) {
		super();
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}

	public StudentData(Integer id, String name, String subject, Double marks) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}
	
	




}
