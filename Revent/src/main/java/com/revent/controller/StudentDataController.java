package com.revent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revent.model.StudentData;
import com.revent.service.StudentDataInterface;
import com.revent.service.StudentDataServ;

@CrossOrigin(origins = "*")
@RestController
public class StudentDataController {

	@Autowired
	private StudentDataInterface stuServ;

	// Endpoint for adding student data record.
	@PostMapping("/addData")
	public StudentData addUser(@RequestBody StudentData user) {
		return stuServ.createData(user);
	}

	// Endpoint for adding multiple student data records.
	@PostMapping("/addDatas")
	public List<StudentData> addUsers(@RequestBody List<StudentData> users) {
		return stuServ.createMultipleData(users);
	}

	// Endpoint for getting a student's data by ID.
	@GetMapping("/student/{id}")
	public StudentData getUserById(@PathVariable int id) {
		return stuServ.getDatatbyId(id);
	}

	// Endpoint for getting a list of all student data records
	@GetMapping("/studentslist")
	public List<StudentData> getAllUsers() {
		return stuServ.getAllData();
	}

	// Endpoint for updating a student's data.
	@PutMapping("/updatedata")
	public StudentData updateUser(@RequestBody StudentData user) {
		return stuServ.updateData(user);
	}

	// Endpoint for deleting a student's data by ID.
	@DeleteMapping("/student/{id}")
	public String deleteUser(@PathVariable int id) {
		return stuServ.deleteDatabyID(id);
	}
}
