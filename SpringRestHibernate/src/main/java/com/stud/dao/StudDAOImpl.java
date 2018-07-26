
package com.stud.dao;


import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.stud.controller.StudController;
import com.stud.model.Stud;
import com.stud.model.StudManytoMany;
import com.stud.model.University;

@Repository
public class StudDAOImpl implements StudDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	 public University getByUniversity_id(long id)
	 {
		 return entityManager.find(University.class, id);
	 }
	
	@Override
	public void saveStudManyDetails(StudManytoMany stud) {
		entityManager.merge(stud);
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	 public List<Stud> getStudsByUniversity(long university_id)
	 
	 {
		System.out.println("university_id=========="+university_id);
		return (List<Stud>) entityManager.createQuery("select s from Stud s where s.university_id =:univid")
				.setParameter("univid", university_id).getResultList();
	 }
	
	@Override
	public void createStudent(Stud student) {
		
		
		System.out.println("*****************"+student.toString());
	
/*		University university= new University("madras", "mu");
		student.setUniversity(university);
		System.out.println(student.getUniversity().toString());*/
	   //  entityManager.persist(student);
	       entityManager.merge(student);
	   // entityManager.persist(university);

	}
	
	

	@Override
	public Stud getStudentById(long id) {
		return entityManager.find(Stud.class, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Stud> getAllStudents() {
		Logger logger = Logger.getLogger(StudController.class);
		logger.debug("all students");
		return (List<Stud>) entityManager.createQuery("select s from Stud s").getResultList();
	}

	@Override
	public void updateStudent(Stud student) {
		entityManager.merge(student);
	}

	@Override
	public void deleteStudent(long id) {
		Stud s = entityManager.find(Stud.class, id);
		entityManager.remove(s);
	}
}