package com.revent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revent.model.StudentData;
@Repository
public interface StudentDataRepo extends JpaRepository<StudentData, Integer>{

}
