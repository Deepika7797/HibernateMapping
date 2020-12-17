package com.hibernate.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.entity.Employee;
import com.hibernate.test.entity.Manager;
import com.hibernate.test.entity.ManagerDetail;
import com.hibernate.test.entity.Project;
import com.hibernate.test.entity.Review;

public class CreateEmployee {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Manager.class).addAnnotatedClass(ManagerDetail.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			Employee emp1 = new Employee("Deepika", "Thangaraj", "deepika@gmail.com");
			Employee emp2 = new Employee("Nivetha", "Vijayan", "nivetha@gmail.com");
			Employee emp3 = new Employee("Krithiga", "Madesh", "krithiga@gmail.com");
			Employee emp4 = new Employee("Suganya", "Aruna", "suganya@gmail.com");
			Employee emp5 = new Employee("Teena", "Butta", "teena@gmail.com");
			session.beginTransaction();
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			session.save(emp5);
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			factory.close();
		}
		
	}
}
