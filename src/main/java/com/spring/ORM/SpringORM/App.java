package com.spring.ORM.SpringORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ORM.SpringORM.DAO.StudentDao;
import com.spring.ORM.SpringORM.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/ORM/SpringORM/config.xml");
        StudentDao studentdao =  (StudentDao) context.getBean("studentDao");
        Student student = new Student(11,"Rushikesh Akolkar","Ahilya-Nagar");
        int r = studentdao.insert(student);
        System.out.println("done id "+r);
    }
}
