package com.revent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revent.model.StudentData;
import com.revent.service.StudentDataServ;

@RestController
public class StudentDataController {

	@Autowired
	private StudentDataServ stuServ;

	@PostMapping("/addData")
	public StudentData addUser(@RequestBody StudentData user) {
		return stuServ.createData(user);
	}

	@PostMapping("/addDatas")
	public List<StudentData> addUsers(@RequestBody List<StudentData> users) {
		return stuServ.createMultipleData(users);
	}

	@GetMapping("/student/{id}")
	public StudentData getUserById(@PathVariable int id) {
		return stuServ.getDatatbyId(id);
	}

	@GetMapping("/studentslist")
	public List<StudentData> getAllUsers() {
		return stuServ.getAllData();
	}
	
	@PutMapping("/updatedata")
	public StudentData updateUser(@RequestBody StudentData user) {
		return stuServ.updateData(user);
	}

	@DeleteMapping("/student/{id}")
	public String deleteUser(@PathVariable int id) {
		return stuServ.deleteDatabyID(id);
	}
}
