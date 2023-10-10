package com.revent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revent.model.StudentData;
import com.revent.repo.StudentDataRepo;

@Service
public class StudentDataServ {

	@Autowired
	private StudentDataRepo stuDataRepo;
	
	public StudentData createData(StudentData stuData) {
	
		return stuDataRepo.save(stuData);
		
	}
	
	public List<StudentData> createMultipleData(List<StudentData> stuData) {
		
		return stuDataRepo.saveAll(stuData);
		
	}
	
	public StudentData getDatatbyId (Integer id){
		return stuDataRepo.findById(id).orElse(null);
	}
	
	public List<StudentData> getAllData (){
		return stuDataRepo.findAll();
	}
	
	public StudentData updateData (StudentData stuData){
		StudentData stu=null;
		Optional <StudentData> oldData=stuDataRepo.findById(stuData.getId());
		
		if(oldData.isPresent()){ 
			
			stu = oldData.get();
			stu.setName(stuData.getName());
			stu.setSubject(stuData.getSubject());
			stu.setMarks(stuData.getMarks());
			
			stuDataRepo.save(stu);
	}else {
		return new StudentData();
	}
		return stu;
	
	}
	
	
	public String deleteDatabyID(Integer id) {
		
		stuDataRepo.deleteById(id);
		return "Data has been deleted successfully";
		
	}
}
