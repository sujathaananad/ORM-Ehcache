package com.stud.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.stud.model.*;

public interface StudDAO {
	
	public University getByUniversity_id(long university_id);
	
	public  List<Stud> getStudsByUniversity(long university_id);
	
	public void createStudent(Stud student);

	public Stud getStudentById(long id);

	public List<Stud> getAllStudents();

	public void updateStudent(Stud student);

	public void deleteStudent(long id);
	
	public void saveStudManyDetails(StudManytoMany stud);


}