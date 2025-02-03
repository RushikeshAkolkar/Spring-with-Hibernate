package com.spring.ORM.SpringORM.DAO;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.ORM.SpringORM.entities.Student;

import antlr.collections.List;

public class StudentDao {
	private HibernateTemplate  hibernatetemplate;
	
	
	
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}



	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}


	//save student
	@Transactional
	public int insert(Student student) {
		
		int i = (int) this.hibernatetemplate.save(student);
		
		return i;
	}
	
	//for getting data from database no need @Transactional Annotation
	
	//get the single object
	public Student getStudent(int studentId) {
		Student student = this.hibernatetemplate.get(Student.class, studentId);
		return student;
	}
	//get all student from database
	public List getAllStudent()
	{
		List students = (List) this.hibernatetemplate.loadAll(Student.class);
		return students;
	}
	
	public void deleteStudent(int studentId)
	{
		Student student= this.hibernatetemplate.get(Student.class,studentId);
		this.hibernatetemplate.delete(student);
	}
	@Transactional
	//updating data
	public void updateStudent(Student student)
	{
		this.hibernatetemplate.update(student);
	}
	
	
	
	
	
	
	
}
