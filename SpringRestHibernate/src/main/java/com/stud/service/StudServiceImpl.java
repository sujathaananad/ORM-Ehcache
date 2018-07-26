package com.stud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.stud.controller.StudController;
import com.stud.dao.StudDAO;
import com.stud.model.Stud;
import com.stud.model.StudManytoMany;
import com.stud.model.University;

@Service
@Transactional
public class StudServiceImpl implements StudService {

	@Autowired
	private StudDAO studentDao;

	@Override
	public void createStudent(Stud student) {
		Logger logger = Logger.getLogger(StudController.class);
		logger.debug(":::Print Service Student:::" + student);
		studentDao.createStudent(student);
	}

	@Transactional
	@Override
	public University getByUniversity_id(long universityid) {
		return studentDao.getByUniversity_id(universityid);
	}
	@Cacheable(value = "studcache")
	@Transactional
	@Override
	public List<Stud> getStudsByUniversity(long university_id) {
		return studentDao.getStudsByUniversity(university_id);
	}

	public void saveStudManyDetails(StudManytoMany stud) {
		studentDao.saveStudManyDetails(stud);

	}
	
    @Cacheable(value = "studcache")
	@Transactional
	@Override
	public Stud getStudentById(long id) {
		Stud student = studentDao.getStudentById(id);
		return student;
	}

	@Transactional
	@Override
	public List<Stud> getAllStudents() {
		List<Stud> list = studentDao.getAllStudents();

		return list;
	}

	@Transactional
	@Override
	public void updateStudent(Stud student) {
		Logger logger = Logger.getLogger(StudController.class);
		logger.debug(":::Print Service Student:::" + student);
		studentDao.updateStudent(student);
	}

	@Transactional
	@Override
	public void deleteStudent(long id) {
		studentDao.deleteStudent(id);
	}

}
