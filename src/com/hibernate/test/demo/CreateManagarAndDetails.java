package com.hibernate.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.entity.Employee;
import com.hibernate.test.entity.Manager;
import com.hibernate.test.entity.ManagerDetail;
import com.hibernate.test.entity.Project;
import com.hibernate.test.entity.Review;

public class CreateManagarAndDetails {

public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Manager.class).addAnnotatedClass(ManagerDetail.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			Manager manager = new Manager("Ananth","Subramanian","ananth@gmail.com");
			ManagerDetail managerDetail = new ManagerDetail(10, "Organising and Coding");
			Manager manager1 = new Manager("Magesh","Mahalingam","magesh@gmail.com");
			ManagerDetail managerDetail1 = new ManagerDetail(10, "Automation and Manual");
			manager.setManagerDetail(managerDetail);
			manager1.setManagerDetail(managerDetail1);
			session.beginTransaction();
			session.save(manager);
			session.save(manager1);
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			factory.close();
		}
}
}
