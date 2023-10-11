package com.revent.service;

import java.util.List;

import com.revent.exception.StudentNotFound;
import com.revent.model.StudentData;



public interface StudentDataInterface {
	public StudentData createData(StudentData stuData);
	
	public List<StudentData> createMultipleData(List<StudentData> stuData) throws StudentNotFound;
	
	public StudentData getDatatbyId (Integer id) throws StudentNotFound;
	
	public List<StudentData> getAllData () throws StudentNotFound;
	
	public StudentData updateData (StudentData stuData)throws StudentNotFound;
	
	
	public String deleteDatabyID(Integer id)throws StudentNotFound;
}
