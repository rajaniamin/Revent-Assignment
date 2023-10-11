package com.revent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revent.exception.StudentNotFound;
import com.revent.model.StudentData;
import com.revent.repo.StudentDataRepo;

@Service
public class StudentDataServ implements StudentDataInterface {

	@Autowired
	private StudentDataRepo stuDataRepo;

	@Override
	public StudentData createData(StudentData stuData) {

		return stuDataRepo.save(stuData);

	}

	@Override
	public List<StudentData> createMultipleData(List<StudentData> stuData) throws StudentNotFound {

		return stuDataRepo.saveAll(stuData);

	}

	@Override
	public StudentData getDatatbyId(Integer id) throws StudentNotFound {
		Optional<StudentData> opt = stuDataRepo.findById(id);
		if (opt.isPresent()) {

			StudentData student = opt.get();

			return student;
		} else
			throw new StudentNotFound("Student does not exist with the roll number :" + id);
	}

	@Override
	public List<StudentData> getAllData() throws StudentNotFound {
		List<StudentData> stu = stuDataRepo.findAll();
		if (stu.isEmpty())
			throw new StudentNotFound("No student available");
		return stu;
	}

	@Override
	public StudentData updateData(StudentData stuData) throws StudentNotFound {
		StudentData stu = null;
		Optional<StudentData> oldData = stuDataRepo.findById(stuData.getId());

		if (oldData.isPresent()) {

			stu = oldData.get();
			stu.setName(stuData.getName());
			stu.setSubject(stuData.getSubject());
			stu.setMarks(stuData.getMarks());

			stuDataRepo.save(stu);
		} else {
			return new StudentData();
		}
		return stu;

	}

	@Override
	public String deleteDatabyID(Integer id) throws StudentNotFound {
		StudentData existingStudent= stuDataRepo.findById(id).orElseThrow(() -> new StudentNotFound("Student does not exist with roll :"+id));
		stuDataRepo.delete(existingStudent);
		return "Data has been deleted successfully";

	}

}
