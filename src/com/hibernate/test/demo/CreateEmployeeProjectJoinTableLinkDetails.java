package com.hibernate.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.entity.Employee;
import com.hibernate.test.entity.Manager;
import com.hibernate.test.entity.ManagerDetail;
import com.hibernate.test.entity.Project;
import com.hibernate.test.entity.Review;

public class CreateEmployeeProjectJoinTableLinkDetails {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Manager.class).addAnnotatedClass(ManagerDetail.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			Project project = session.get(Project.class, 14);
			Project project1 = session.get(Project.class, 16);
			Project project2 = session.get(Project.class, 17);
			Employee emp1 = session.get(Employee.class, 1);
			Employee emp2 = session.get(Employee.class, 2);
			Employee emp3 = session.get(Employee.class, 4);
			Employee emp4 = session.get(Employee.class, 5);
			project.addEmployee(emp1);
			project.addEmployee(emp2);
			project1.addEmployee(emp3);
			project2.addEmployee(emp4);
			project2.addEmployee(emp2);
			session.getTransaction().commit();
			
		}

		finally
		{
			session.close();
			factory.close();
		}
	}

}
