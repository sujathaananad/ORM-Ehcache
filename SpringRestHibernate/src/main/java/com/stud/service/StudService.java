package com.stud.service;

import java.util.List;

import com.stud.model.Stud;
import com.stud.model.StudManytoMany;
import com.stud.model.University;

public interface StudService {
	
	public University getByUniversity_id(long university_id);
	
	public  List<Stud> getStudsByUniversity(long university_id);
	
	public void createStudent(Stud student);

	public Stud getStudentById(long id);

	public List<Stud> getAllStudents();

	public void updateStudent(Stud student);

	public void deleteStudent(long id);

	public void saveStudManyDetails(StudManytoMany stud);

}