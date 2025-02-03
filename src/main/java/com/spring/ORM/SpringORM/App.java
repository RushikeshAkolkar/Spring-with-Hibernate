package com.spring.ORM.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		/*
		 * Student student = new Student(11,"Rushikesh Akolkar","Ahilya-Nagar"); int r =
		 * studentdao.insert(student); System.out.println("done id "+r);
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go =true;
        while (go) {
        	int id;
        	String name;
        	String city;
        	int r;
        	
        	System.out.println("1.add new Student");
            System.out.println("2.Display all Student");
            System.out.println("3.get All Details of Single Student");
            System.out.println("4.delete Student");
            System.out.println("5.update Student");
            System.out.println("6.Exit");
            
            try {
            	int input=Integer.parseInt(br.readLine());
            	switch (input) {
				case 1:
					System.out.println("Enter id ,name, city");
					id =Integer.parseInt(br.readLine());
					name = br.readLine();
					city = br.readLine();
					Student student=new Student(id,name,city);
					r=studentdao.insert(student);
					System.out.println("Record inserted "+r);
					
					break;
				case 2:
					System.out.println("All The Student are here");
					ArrayList<Student> students =  (ArrayList<Student>) studentdao.getAllStudent();
					students.forEach(System.out::println);
					break;
				case 3:
					System.out.println("Enter Student id which you want");
					id =Integer.parseInt(br.readLine());
					System.out.println("Details of single Student is here :");
					studentdao.getStudent(id);
					break;
				case 4:
					System.out.println("Enter Student id which you want to delete");
					id =Integer.parseInt(br.readLine());
					System.out.println("Details of single Student is here :");
					studentdao.getStudent(id);
					System.out.println("Student got deleted");
					break;
				case 5:
					System.out.println("Enter id ,name, city");
					id =Integer.parseInt(br.readLine());
					name = br.readLine();
					city = br.readLine();
					Student stud=new Student(id,name,city);
					studentdao.updateStudent(stud);
					System.out.println("Record Updated inserted ");
					break;
				case 6:
					go=false;
					break;
				}
            	
            	
            	
			} catch (Exception e) {
				System.out.println("Invalid Input try with another one");
				System.out.println(e.getMessage());
			}
		}
        
        
        
        
    }
}
