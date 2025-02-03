package com.spring.ORM.SpringORM.DAO;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.ORM.SpringORM.entities.Student;

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
	
	
}
